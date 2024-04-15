import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test
    public void positive0() {
        Assert.assertEquals(FactorialCalculator.factorial(0), 1, "Факториал 0 равен 1");
    }

    @Test
    public void positive1() {
        Assert.assertEquals(FactorialCalculator.factorial(1), 1, "Факториал 1 равен 1");
    }

    @Test
    public void positive5() {
        Assert.assertEquals(FactorialCalculator.factorial(5), 120, "Факториал 5 равен 120");
    }

    @Test
    public void positive20() {
        Assert.assertEquals(FactorialCalculator.factorial(20), 2_432_902_008_176_640_000L, "Факториал 20 равен 2_432_902_008_176_640_000");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negative1() {
        FactorialCalculator.factorial(-1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negative3() {
        FactorialCalculator.factorial(-3);
    }
}