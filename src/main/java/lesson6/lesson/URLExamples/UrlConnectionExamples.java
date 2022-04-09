/**
 * Created by Yulya Telysheva
 */
package lesson6.lesson.URLExamples;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlConnectionExamples {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https", "gb.ru", "/");

        InputStream in = url.openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        //читать будем построчно, поэтому нужно куда-то сохранять
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //System.out.println(line);

        }
        bufferedReader.close();

        URL url1 = new URL("https://restful-booker.herokuapp.com/auth");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();

        //http протокол это договоренность между системами о том в каком формате сообщениями они будут обмениваться
        //Сейчаc будем создавать запрос типа POST с помощью httpURLConnection
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);//Специфицирует, что нужен ответ на запрос

        String requestBody = "{\n" +
                " \"username\" : \"admin\",\n" +
                " \"password\" : \"password123\"\n" +
                "}";

        //Теперь нужно отправить этот запрос
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter
                (httpURLConnection.getOutputStream()));

        bufferedWriter.write(requestBody);

        //Теперь нужно получить ответ
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String temp;
        while ((temp = bufferedReader1.readLine()) != null) {
            System.out.println(temp);//если всё хорошо, то вернется логин
            //Bad credentials означает, что логин или пароль неправильный
        }
    }

}
