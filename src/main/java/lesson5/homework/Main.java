/**
 * Created by Yulya Telysheva
 */
package lesson5.homework;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("datahw5.csv");
        System.out.println(file.exists());

        AppData data = new AppData();
        data.load("datahw5.csv");
        data.save("savedatahw5");
        System.out.println(data);

    }
}
