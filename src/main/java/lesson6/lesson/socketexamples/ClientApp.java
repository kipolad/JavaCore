/**
 * Created by Yulya Telysheva
 */
package lesson6.lesson.socketexamples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        //Клиент будет стучаться на порт и отправлять на сокет строчку
        Scanner scanner = new Scanner(System.in);

        //Строим сокет.
        // Нужно передать 2 параметра: хост и порт.
        // Вместо localhost можно ввести ip адрес
        try (Socket socket = new Socket("localhost", 1234)) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            //Клиент будет ждать и принимать строки сколько угодно
            while (true) {
                System.out.print("Введите сообщение: ");
                String request = scanner.nextLine();

                dataOutputStream.writeUTF(request);

                if ("end".equals(request)) break;

                System.out.println("Получили ответ от сервера: " + dataInputStream.readUTF());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
