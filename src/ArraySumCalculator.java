public class ArraySumCalculator {
    public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        for (String[] arrayRow : array) {
            if (array.length != 4 || arrayRow.length != 4)
                throw new MyArraySizeException("Массив другого размера, на вход должен подаваться двумерный строковый массив размером 4х4.");
        }
        int sumArray = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sumArray += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException numberFormatException) {
                    throw new MyArrayDataException("В ячейке [" + i + "][" + j + "] лежит символ или текст - '" + array[i][j] + "', вместо числа.");
                }
            }
        }
        return sumArray;
    }
}