/**
 * Created by Yulya Telysheva
 */
package lesson6.lesson.URLExamples;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OKHttpExamples {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("gb.ru")
                .addPathSegment("/courses")
                .build();
        //По конструктору по умолчанию создался объект по данным сетторам.
        // Можно указать порт, но он и так работает по умолчанию.

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.body().string());

    }
}
