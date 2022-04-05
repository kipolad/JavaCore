/**
 * Created by Yulya Telysheva
 */
package lesson5.lesson;

import java.io.*;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterExamples {
    public static void main(String[] args) {
        //Чтение
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("out_example.txt"), UTF_8)) {
            int x;
            while ((x = inputStreamReader.read()) != -1) {
                System.out.println(x);
                System.out.println((char) x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Читаем с помощью буфера
        //Буфер нужен, чтобы читать большие куски быстрее
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("out_example.txt"))) {
            System.out.println(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Student> students = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("students.txt"))) {
            String tempString;
            //временно сохранять чтения
            while((tempString = bufferedReader.readLine()) != null){
                String[] studentParams = tempString.split(" ");
                students.add(new Student(studentParams[0], studentParams[1], Integer.parseInt(studentParams[2])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(students);

        //PrintWriter нужен для записи символьных потоков
        try (PrintWriter printWriter = new PrintWriter("new_students.csv")) {
            for (Student student : students) {
                printWriter.println(student.toString());
            }
        } catch (FileNotFoundException e ) {
            e.printStackTrace();
        }

    }
}
