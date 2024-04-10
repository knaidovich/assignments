public class Main {
    public static void main(String[] args) {
        String[][] testArray = {
                {"11", "-22", "11", "7"},
                {"6", "52", "32", "-90"},
                {"90", "29", "72", "10"},
                {"-22", "44", "-150", "w"}
        };

        try {
            System.out.println("Сумма элементов массива: " + sumArrayElements(testArray));
        } catch (MyArraySizeException | MyArrayDataException arrayException) {
            System.out.println(arrayException.getMessage());
        }
    }

    public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4)
            throw new MyArraySizeException("Массив другого размера, на вход должен подаваться двумерный строковый массив размером 4х4.");
        for (String[] arrayRow : array) {
            if (arrayRow.length != 4)
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

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }
}