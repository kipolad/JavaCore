/**
 * Created by Yulya Telysheva
 */
package lesson2.lesson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ALotOfExceptions {
    public static void main(String[] args) {
        //это все UncheckedExceptions их не следует оборачивать в try
        InputStream inputStream; // переменная = null

        try {
            String[] array = {"sdf", "kkdkj"};
            String string = array[2];

            int a = 1 / 0;
            inputStream = new FileInputStream("fdasd");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.err.println("арифметика");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("массив"); //выведет только массив, т.к. другие ошибки ниже и будут проигнорированы
        }
        finally {
            System.out.println("finally");
        }
        // Нельзя ставить сразу в catch (Exception e)
        System.out.println("live");
    }


}
