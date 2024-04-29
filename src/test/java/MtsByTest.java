import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MtsByTest {

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
    @Order(1)
    @DisplayName("1) Проверка названия блока 'Онлайн пополнение без комиссии'")
    public void testBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        assertTrue(blockTitle.isDisplayed(), "Название блока 'Онлайн пополнение без комиссии' не найдено или не отображается");
        assertEquals("Онлайн пополнение\nбез комиссии", blockTitle.getText(), "Текст заголовка не соответствует ожидаемому");
    }

    @Test
    @Order(2)
    @DisplayName("2) Проверка наличия логотипов платёжных систем")
    public void testPaymentSystemLogos() {
        String[] xpaths = {
                "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img",
                "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]/img",
                "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img",
                "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img",
                "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img",
                "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[6]/img"
        };
        for (String xpath : xpaths) {
            WebElement logo = driver.findElement(By.xpath(xpath));
            assertTrue(logo.isDisplayed(), "Логотип не найден или не отображается");
        }
    }

    @Test
    @Order(3)
    @DisplayName("3) Проверка работы ссылки 'Подробнее о сервисе'")
    public void testMoreDetailsLink() {
        WebElement moreDetailsLink = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a"));
        moreDetailsLink.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl(), "Ссылка 'Подробнее о сервисе' ведет не на ожидаемую страницу");
    }

    @Test
    @Order(4)
    @DisplayName("4) Проверка работы кнопки 'Продолжить'")
    public void testContinueButton() {
        WebElement phoneInput = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        phoneInput.sendKeys("297777777");

        WebElement amountInput = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        amountInput.sendKeys("1");

        WebElement payButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        payButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bepaid-app__container > iframe")));
        driver.switchTo().frame(iframe);

        WebElement modalText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pay-description__text")));
        boolean textAppeared = wait.until(ExpectedConditions.textToBePresentInElement(modalText, "Оплата: Услуги связи Номер:375297777777"));

        assertTrue(textAppeared, "Текст в модальном окне не соответствует ожидаемому или не появился");

        driver.switchTo().defaultContent();
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