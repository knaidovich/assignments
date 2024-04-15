public class FactorialCalculator {

    public static long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Число не должно быть отрицательным");
        }

        long result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }
}