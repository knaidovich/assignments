public class Main {
    public static void main(String[] args) {
        String[][] testArray = {
                {"11", "-22", "11", "7"},
                {"6", "52", "32", "-90"},
                {"90", "29", "72", "10"},
                {"-22", "44", "-150", "w"}
        };
        try {
            System.out.println("Сумма элементов массива: " + ArraySumCalculator.sumArrayElements(testArray));
        } catch (MyArraySizeException | MyArrayDataException arrayException) {
            System.out.println(arrayException.getMessage());
        }
    }
}