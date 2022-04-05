/**
 * Created by Yulya Telysheva
 */
package lesson5.lesson;

import java.io.*;

public class SerializationExamples {
    //сериализация и десериализация
    public static void main(String[] args) {
        File file = new File("student");

        Student student = new Student("Anton", "Ivanov", 19);
        Student student2 = new Student("Anton", "Ivanov", 21);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(student);//без сериализации java не умеет разбирать объект на кусочки. Нужен для класса Student implements Serializable
            objectOutputStream.writeObject(student2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //файл student можно открыть с помощью умного блокнота

        //Теперь обратно соберем из кусочков объект
        File file1 = new File("newstudent");

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            Student studentFromFile = (Student) objectInputStream.readObject();
            Student studentFromFile1 = (Student) objectInputStream.readObject();

            System.out.println(studentFromFile);
            System.out.println(studentFromFile1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();//когда java не знает от какого класса она собирает объекты
        }
    }
}
