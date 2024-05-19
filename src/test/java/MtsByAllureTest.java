import io.qameta.allure.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MtsByAllureTest {

    private WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        acceptCookieConsent();
    }

    @Test
    @DisplayName("1.1) Проверка надписей в незаполненных полях варианта оплаты: услуги связи.")
    @Description("Проверка, что надписи в незаполненных полях соответствуют ожидаемым значениям.")
    @Feature("Payment")
    @Story("Connection Service")
    public void testConnectionServicePlaceholders() {
        WebElement dropdown = driver.findElement(By.id("pay"));
        dropdown.findElement(By.xpath("./option[1]")).click();

        WebElement phoneNumberField = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        WebElement sumField = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        WebElement emailField = driver.findElement(By.xpath("//*[@id='connection-email']"));

        assertEquals("Номер телефона", phoneNumberField.getAttribute("placeholder"));
        assertEquals("Сумма", sumField.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", emailField.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("1.2) Проверка надписей в незаполненных полях варианта оплаты: домашний интернет.")
    @Description("Проверка, что надписи в незаполненных полях соответствуют ожидаемым значениям.")
    @Feature("Payment")
    @Story("Home Internet")
    public void testHomeInternetPlaceholders() {
        WebElement dropdown = driver.findElement(By.id("pay"));
        dropdown.findElement(By.xpath("./option[2]")).click();

        WebElement subscriberNumberField = driver.findElement(By.xpath("//*[@id='internet-phone']"));
        WebElement sumField = driver.findElement(By.xpath("//*[@id='internet-sum']"));
        WebElement emailField = driver.findElement(By.xpath("//*[@id='internet-email']"));

        assertEquals("Номер абонента", subscriberNumberField.getAttribute("placeholder"));
        assertEquals("Сумма", sumField.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", emailField.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("1.3) Проверка надписей в незаполненных полях варианта оплаты: рассрочка.")
    @Description("Проверка, что надписи в незаполненных полях соответствуют ожидаемым значениям.")
    @Feature("Payment")
    @Story("Instalment")
    public void testInstalmentPlaceholders() {
        WebElement dropdown = driver.findElement(By.id("pay"));
        dropdown.findElement(By.xpath("./option[3]")).click();

        WebElement accountNumberField = driver.findElement(By.xpath("//*[@id='score-instalment']"));
        WebElement sumField = driver.findElement(By.xpath("//*[@id='instalment-sum']"));
        WebElement emailField = driver.findElement(By.xpath("//*[@id='instalment-email']"));

        assertEquals("Номер счета на 44", accountNumberField.getAttribute("placeholder"));
        assertEquals("Сумма", sumField.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", emailField.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("1.4) Проверка надписей в незаполненных полях варианта оплаты: задолженность.")
    @Description("Проверка, что надписи в незаполненных полях соответствуют ожидаемым значениям.")
    @Feature("Payment")
    @Story("Arrears")
    public void testArrearsPlaceholders() {
        WebElement dropdown = driver.findElement(By.id("pay"));
        dropdown.findElement(By.xpath("./option[4]")).click();

        WebElement accountNumberField = driver.findElement(By.xpath("//*[@id='score-arrears']"));
        WebElement sumField = driver.findElement(By.xpath("//*[@id='arrears-sum']"));
        WebElement emailField = driver.findElement(By.xpath("//*[@id='arrears-email']"));

        assertEquals("Номер счета на 2073", accountNumberField.getAttribute("placeholder"));
        assertEquals("Сумма", sumField.getAttribute("placeholder"));
        assertEquals("E-mail для отправки чека", emailField.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("2) Тест процесса оплаты на странице 'Онлайн пополнение без комиссии'")
    @Description("Проверка процесса оплаты на странице 'Онлайн пополнение без комиссии'.")
    @Feature("Payment")
    @Story("Online Recharge")
    public void testContinueButton() {
        WebElement phoneInput = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        phoneInput.sendKeys("297777777");

        WebElement amountInput = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        amountInput.sendKeys("1");

        WebElement payButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        payButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bepaid-app__container > iframe")));
        driver.switchTo().frame(iframe);

        WebElement displayedAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div/span[1]")));
        assertEquals("1.00 BYN", displayedAmount.getText(), "Отображаемая сумма не соответствует ожидаемой");

        WebElement displayedPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/span")));
        assertEquals("Оплата: Услуги связи Номер:375297777777", displayedPhone.getText(), "Отображаемый телефон не соответствует ожидаемому");

        WebElement displayedAmountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button")));
        assertEquals("Оплатить 1.00 BYN", displayedAmountButton.getText(), "Отображаемая сумма на кнопке не соответствует ожидаемой");

        String[] xpaths = {
                "//img[contains(@src, 'mastercard-system')]",
                "//img[contains(@src, 'visa-system')]",
                "//img[contains(@src, 'belkart-system')]",
                "//img[contains(@src, 'mir-system')]",
                "//img[contains(@src, 'maestro-system')]",
        };

        boolean isAnyOptionalImageDisplayed = false;

        // Проверка видимости первых трех картинок
        for (int i = 0; i < 3; i++) {
            WebElement logo = driver.findElement(By.xpath(xpaths[i]));
            assertTrue(logo.isDisplayed(), "Картинка " + (i + 1) + " не отображается");
        }

        // Проверка видимости четвертой или пятой картинки
        for (int i = 3; i <= 4; i++) {
            try {
                WebElement logo = driver.findElement(By.xpath(xpaths[i]));
                if (logo.isDisplayed()) {
                    isAnyOptionalImageDisplayed = true;
                    break;
                }
            } catch (NoSuchElementException e) {
            }
        }
        assertTrue(isAnyOptionalImageDisplayed, "Ни четвертая, ни пятая картинки не отображаются.");

        WebElement cardNumberField = driver.findElement(By.xpath("//label[@class='ng-tns-c45-1 ng-star-inserted' and contains(text(), 'Номер карты')]"));
        WebElement expiryDateField = driver.findElement(By.xpath("//label[@class='ng-tns-c45-4 ng-star-inserted' and contains(text(), 'Срок действия')]"));
        WebElement nameField = driver.findElement(By.xpath("//label[@class='ng-tns-c45-3 ng-star-inserted' and contains(text(), 'Имя держателя (как на карте)')]"));
        WebElement cvcField = driver.findElement(By.xpath("//label[@class='ng-tns-c45-5 ng-star-inserted' and contains(text(), 'CVC')]"));

        assertEquals("Номер карты", cardNumberField.getText(), "Текст у элемента не соответствует 'Номер карты'");
        assertEquals("Срок действия", expiryDateField.getText(), "Текст у элемента не соответствует 'Срок действия'");
        assertEquals("Имя держателя (как на карте)", nameField.getText(), "Текст у элемента не соответствует 'Имя держателя (как на карте)'");
        assertEquals("CVC", cvcField.getText(), "Текст у элемента не соответствует 'CVC'");
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void acceptCookieConsent() {
        try {
            WebElement acceptButton = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cookie-agree']")));
            acceptButton.click();
        } catch (TimeoutException e) {
            throw new RuntimeException("Ошибка: кнопка согласия на использование cookies не стала кликабельной в течение заданного времени.", e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Ошибка: элемент для согласия на использование cookies не найден на странице.", e);
        } catch (ElementNotInteractableException e) {
            throw new RuntimeException("Ошибка: элемент для согласия на использование cookies не интерактивен.", e);
        }
    }
}