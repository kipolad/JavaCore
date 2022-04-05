/**
 * Created by Yulya Telysheva
 */
package lesson5.lesson;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StreamsExample {
    //байтовые потоки
    public static void main(String[] args) {
        String tempString = "cat";
        String tempString1 = "кот";

        System.out.println(Arrays.toString(tempString.getBytes()));//Превратит tempString в поток байт
        System.out.println(Charset.defaultCharset());//Кодировка по умолчанию
        //System.out.println(Charset.availableCharsets());Все кодировки, с которыми java умеет работать
        System.out.println(Arrays.toString(tempString1.getBytes()));
        // будет [-48, -70, -48, -66, -47, -126] т.к. кириллица не влезает в кодировку.
        // Здесь для кодирования каждого символа нужно 2 байта. В 1 байте 8 бит.
        // 00000000 11111111 2^8 = 256 вариантов можно закодировать 1 байтом.
        // отрицательные числа в отображении потому что java делает
        // 1 -> 127 -> -128 -> 0    если у нас -48, то будет 128 + 128 - 48 = 208

        System.out.println((byte) 208);

        File file = new File("out_example.txt");
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(tempString1.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //OutputStream outputStream1 = new FileOutputStream(file); если оставить так, то файл перезапишется.

        //ресурсный вариант try

        try (OutputStream outputStream1 = new FileOutputStream(file, true)) {//true значит аппенд - добавляем к файлу.
            outputStream1.write(65); //к файлу добавится в конце буква А = catA
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*//Замерить как долго идет запись в файл
        long time = System.currentTimeMillis();
        //повторить прошлую запись
        try (OutputStream outputStream2 = new FileOutputStream(file, true)) {
            //записать 5млн раз букву А.
            //Получится везде открыть поток, записать, закрыть поток - уходит каждый раз много ресурсов.
            for (int i = 0; i < 5*1024 * 1024; i++) {
                outputStream2.write(65);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Время на запись 5 мегабайт: " + (System.currentTimeMillis() - time));
*/
        //Теперь сделаем с помощью BufferedWriter
        //Сначала всё передается в поток и только в конце сохраняется.
        long time = System.currentTimeMillis();
        try (OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream("test2.txt"))) {
            for (int i = 0; i < 5 * 1024 * 1024; i++) {
                outputStream2.write(65);
                //outputStream2.flush();очистка буфера. Получится: записали 1 символ, очистили, записали и т.д.
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Время на запись 5 мегабайт с буферизацией: " + (System.currentTimeMillis() - time));

        try (InputStream inputStream = new FileInputStream("out_example.txt")) {
            for (int i = 0; i < new File("out_example.txt").length(); i++) {
                System.out.println("i = " + (char) inputStream.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        //Теперь попробуем через байтовый поток

        byte[] bytes = null;
        try (InputStream inputStream = new FileInputStream("out_example.txt")) {
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Прочитали с помощью байтового потока " + new String(bytes, StandardCharsets.UTF_8));

        //С байтовыми потоками работать быстрее, но необходимо учитывать их особенности

        //Создание файла студентов для парсинга
        String[] students = {"Иван Иванов 20", "Петр Петров 21", "Жук Жуковский 18"};

        File fileStudent = new File("students.txt");

        try (OutputStream outputStreamForStudents = new FileOutputStream(fileStudent)) {
            for (String student : students) {
                outputStreamForStudents.write((student.getBytes(StandardCharsets.UTF_8)));
                outputStreamForStudents.write("\n".getBytes(StandardCharsets.UTF_8));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
