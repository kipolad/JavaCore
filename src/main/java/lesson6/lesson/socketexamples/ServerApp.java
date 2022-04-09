/**
 * Created by Yulya Telysheva
 */
package lesson6.lesson.socketexamples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        //приложение имеет порт в другие приложения для обмена сообщениями.
        // Сервер имеет свои порты, куда подключаются клиенты.
        //Запускаем сервер сокет, который слушает порт 1234
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен, ожидает соединение...");

            //к нам стучится клиентское приложение и нам нужно его принять
            Socket socket = serverSocket.accept();//без условий принимаем приложение
            System.out.println("Клиент подключился!");

            //теперь через сокет можно гонять стримы
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            //тоже нужно сделать для input stream чтобы общение могло идти в обе стороны
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while (true) {
                String clientRequest = dataInputStream.readUTF();
                if ("end".equals(clientRequest)) break;

                System.out.println("Получили строку: " + clientRequest);
                dataOutputStream.writeUTF("Сервер отвечает: " + clientRequest);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
