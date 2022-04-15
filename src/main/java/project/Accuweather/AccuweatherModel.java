/**
 * Created by Yulya Telysheva
 */
package project.Accuweather;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import project.forecast.Weather;
import project.weatherfromdb.SimpleWeather;

import java.io.IOException;
import java.util.List;

public class AccuweatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/
    private static final String PROTOCOL = "https";
    private static final String HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "W5YCCVYJZ1NKqhYRgryEf24g9oMSbcGs";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final String SPB_KEY = "295212";

    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private DatabaseRepository databaseRepository = new DatabaseRepository();

    //pXJd8MokcZCdrd2MsoGl2DBZAyCa0zvv запасной API_KEY
    @Override
    public void getWeather(String selectedCity, Period period) throws IOException {
        HttpUrl httpUrl;
        Request request;
        String weatherResponse = null;
        switch (period) {
            case NOW -> {
                httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();
                request = new Request.Builder()
                        .url(httpUrl)
                        .build();
                Response oneDayForecastResponse = OK_HTTP_CLIENT.newCall(request).execute();//newCall - новый запрос, execute - выполнить
                weatherResponse = oneDayForecastResponse.body().string().toLowerCase();

                OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                Weather weather = OBJECT_MAPPER.readValue(weatherResponse, Weather.class);
                weather.setCity(selectedCity);
                System.out.println(weather);

                System.out.println("-----------------");
                System.out.println(databaseRepository.saveWeatherToDatabase(weather));
            }

            case FIVE_DAYS -> {
                httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();
                request = new Request.Builder()
                        .url(httpUrl)
                        .build();
                Response fiveDayForecastResponse = OK_HTTP_CLIENT.newCall(request).execute();
                weatherResponse = fiveDayForecastResponse.body().string().toLowerCase();

                OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                Weather weather = OBJECT_MAPPER.readValue(weatherResponse, Weather.class);
                weather.setCity(selectedCity);
                System.out.println(weather);

                System.out.println("-----------------");
                System.out.println(databaseRepository.saveWeatherToDatabase(weather));
            }
        }
        System.out.println("-----------------------");
        System.out.println(databaseRepository.getSavedToDBWeather());
    }

    @Override
    public List<SimpleWeather> getSavedToDBWeather() {
        return databaseRepository.getSavedToDBWeather();
    }

    private String detectCityKey(String selectedCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response cityResponse = OK_HTTP_CLIENT.newCall(request).execute();//newCall - новый запрос, execute - выполнить
        String weatherResponce = cityResponse.body().string();

        //распарсим ответ, вырезаем ключ к городу
        String cityKey = OBJECT_MAPPER.readTree(weatherResponce).get(0).at("/Key").asText();
        return cityKey;
    }

    public static void main(String[] args) throws IOException {
        UserInterfaceView userInterfaceView = new UserInterfaceView();
        userInterfaceView.runInterface();
    }
}
