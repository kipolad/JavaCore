/**
 * Created by Yulya Telysheva
 */
package lesson6.homework;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuweatherAPI {
    private static final String API_KEY = "W5YCCVYJZ1NKqhYRgryEf24g9oMSbcGs";

    private static final String PROTOCOL = "https";
    private static final String HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String SPB_KEY = "295212";

    private static final OkHttpClient okHttpClient = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        getWeather();
    }

    public static void getWeather() throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(HOST)
                .addPathSegment(FORECASTS)
                .addPathSegment(VERSION)
                .addPathSegment(DAILY)
                .addPathSegment(FIVE_DAY)
                .addPathSegment(SPB_KEY)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
        String weatherResponse = oneDayForecastResponse.body().string();
        System.out.println(weatherResponse);
    }
}
