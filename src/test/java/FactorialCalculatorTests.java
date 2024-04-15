import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTests {

    @Test
    public void positive0() {
        assertEquals(1, FactorialCalculator.factorial(0), "Факториал 0 равен 1");
    }

    @Test
    public void positive1() {
        assertEquals(1, FactorialCalculator.factorial(1), "Факториал 1 равен 1");
    }

    @Test
    public void positive5() {
        assertEquals(120, FactorialCalculator.factorial(5), "Факториал 5 равен 120");
    }

    @Test
    public void positive20() {
        assertEquals(2_432_902_008_176_640_000L, FactorialCalculator.factorial(20), "Факториал 20 равен 2_432_902_008_176_640_000");
    }

    @Test
    public void negative1() {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.factorial(-1), "Факториал отрицательного числа должен вызывать исключение");
    }

    @Test
    public void negative3() {
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.factorial(-3), "Факториал отрицательного числа должен вызывать исключение");
    }
}