/**
 * Created by Yulya Telysheva
 */
package lesson4.lesson;

import java.util.Arrays;
import java.util.Random;

public class Passports {
    public static void main(String[] args) {
        Integer[] passports = new Integer[50]; //У нас 50 сотрудников
        Random random = new Random();
        for (int i = 0; i < passports.length; i++) {
            passports[i] = random.nextInt(999999) + 100000;
        }
        System.out.println(Arrays.toString(passports));

        Integer[] newPassports = new Integer[51]; // Создаем новый массив увеличенной длины
        System.arraycopy(passports, 0, newPassports, 0, passports.length);//делаем копию старого массива
        newPassports[50] = 123456; //вставляем в новый массив последним элементом данные
        //Меняем ссылки.
        passports = newPassports; //Перекидываем ссылку на переменную passports.
        newPassports = null; //Обнуляем ссылку, чтобы сборщик мусора удалил объект.

        System.out.println(Arrays.toString(passports));


    }
}
