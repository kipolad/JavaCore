/**
 * Created by Yulya Telysheva
 */
package lesson2.lesson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CheckedException {
    public static void main(String[] args) {
        // если добавить в сигнатуру throws FileNotFoundException, то всё равно придется где-то обработать
        // потому что он где-нибудь свалится
        // либо нет возможности обработать в этом месте и нужно пробросить ответственность на
        // обработку в др месте
        try {
            InputStream inputStream = new FileInputStream("фыва");// Обратимся к файлу и будем читать с него (путь в скобках указать)
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // catch может быть сколько угодно
        System.out.println("live!");
    }
}
