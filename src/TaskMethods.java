public class TaskMethods {
    public static void printThreeWords() {
        System.out.println("Задание 1:");
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        System.out.println("Задание 2:");
        int a = 5;
        int b = -3;
        System.out.println((a + b >= 0) ? "Сумма положительная" : "Сумма отрицательная");
    }

    public static void printColor() {
        System.out.println("Задание 3:");
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        System.out.println("Задание 4:");
        int a = 7;
        int b = 8;
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    public static boolean isSumInRange(int a, int b) {
        System.out.println("Задание 5:");
        return a + b >= 10 && a + b <= 20;
    }

    public static void checkPositiveOrNegative(int number) {
        System.out.println("Задание 6:");
        System.out.println(number >= 0 ? "Число " + number + " положительное" : "Число " + number + " отрицательное");
    }

    public static boolean isNegative(int number) {
        System.out.println("Задание 7:");
        return number < 0;
    }

    public static void printStringMultipleTimes(String s, int count) {
        System.out.println("Задание 8:");
        for (int i = 0; i < count; i++) {
            System.out.println(s);
        }
    }

    public static boolean isLeapYear(int year) {
        System.out.println("Задание 9:");
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void invertArrayValues() {
        System.out.println("Задание 10:");
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void fillArray() {
        System.out.println("Задание 11:");
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void doubleValuesLessThanSix() {
        System.out.println("Задание 12:");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void fillDiagonal() {
        System.out.println("Задание 13:");
        int size = 5;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
            matrix[i][size - i - 1] = 1;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void initArray(int len, int initialValue) {
        System.out.println("Задание 14:");
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
            System.out.print(array[i] + " ");
        }
    }
}