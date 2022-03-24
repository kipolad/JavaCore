/**
 * Created by Yulya Telysheva
 */
package lesson2.homework;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {{"1", "3", "h"}, {"3", "6", "k", "8"},
                {"", "0", "1", "2"}, {"3", "4", "5", "6"}};
        int result = sumOfArrayElements(arr);
        System.out.println("Сумма всех чисел в массиве: " + result);
    }

    static int sumOfArrayElements(String[][] array) {
        int sum = 0;
        checkArrayLengthFour(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (!isNumber(array[i][j])) {
                    try {
                        throw new MyArrayDataException("В строке: [" + i + "][" + j + "] неверный формат числа!");
                    } catch (MyArrayDataException e) {
                        System.err.println(e);
                    }
                } else if (array[i][j].isEmpty()) {
                    try {
                        throw new MyArrayDataException("Строка: [" + i + "][" + j + "] пустая!");
                    } catch (MyArrayDataException e) {
                        System.err.println(e);
                    }
                } else {
                    sum += Integer.parseInt(array[i][j]);
                }
            }
        }
        return sum;
    }

    static void checkArrayLengthFour(String[][] array) {
        boolean isWrongLength = false;
        if (array.length != 4) {
            isWrongLength = true;
        } else {//массив может быть не равномерным, нужно проверить по каждой строке
            for (String[] strings : array) {
                if (strings.length != 4) {
                    isWrongLength = true;
                    break;
                }
            }
        }
        if (isWrongLength) {
            try {
                throw new MyArraySizeException("Длина массива не равна 4!");
            } catch (MyArraySizeException e) {
                System.err.println(e);
            }
        }
    }

    static boolean isNumber(String value) {
        char charFromString;
        boolean isNumber = true;
        for (int index = 0; index < value.length(); index++) {
            charFromString = value.charAt(index);
            if (!Character.isDigit(charFromString)) {
                isNumber = false;
                break;
            }
        }
        return isNumber;
    }
}
