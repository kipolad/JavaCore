/**
 * Created by Yulya Telysheva
 */
package lesson5.lesson;

import java.io.File;
import java.io.IOException;

public class FileExamples {
    //FileInputStream используется для чтения из файлов.
    //BufferedInputStream для работы с файлами, но с помощью буфера.
    public static void main(String[] args) throws IOException {
        File file = new File("1.txt"); //Будет искать файл 1.txt в корне проекта
        //если написать название без разрешения, то будет путь к папке или создастся папка.
        System.out.println(file.exists());//exists() есть такой файл?

        File file2 = new File("2.txt");
        file2.createNewFile(); //в папку target проекта добавлен файл 2.txt
        System.out.println(file2.exists());
        System.out.println(file2.length());//вывести размер файла 2.txt

        file2.delete();//удалит сразу
        //file2.deleteOnExit();удалит по завершению программы (сначала временно попользоваться)

        //File filePath = new File("11");
        //filePath.mkdir(); создаст папку из корня проекта

        //File filePath2 = new File("1/2/3/4");
        //filePath.mkdirs(); создаст путь из папок с вложенными папками в соответствии с заданной структурой
        //System.out.println(filePath2.length()); покажет длину пути из папок

        File currentFolder = new File(".");
        for (File temp : currentFolder.listFiles()) {
            System.out.println(temp.getName()); //отобразит содержимое текущего проекта, имена файлов в папке т.к. File(".")
        }




    }
}
