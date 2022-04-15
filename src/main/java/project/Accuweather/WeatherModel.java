package project.Accuweather;
import project.weatherfromdb.SimpleWeather;

import java.io.IOException;
import java.util.List;

public interface WeatherModel {
    //Реализуя данный интерфейс можно заменить AccuweatherModel
    void getWeather(String selectedCity, Period period) throws IOException;

    List<SimpleWeather> getSavedToDBWeather();
}
