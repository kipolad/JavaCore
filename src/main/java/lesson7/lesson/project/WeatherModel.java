package lesson7.lesson.project;


import java.io.IOException;

public interface WeatherModel {
    //Реализуя данный интерфейс можно заменить AccuweatherModel
    void getWeather(String selectedCity, Period period) throws IOException;
}
