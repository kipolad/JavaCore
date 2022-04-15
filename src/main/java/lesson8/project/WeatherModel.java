package lesson8.project;


import lesson8.project.entity.EntityWeather;

import java.io.IOException;
import java.util.List;

public interface WeatherModel {
    //Реализуя данный интерфейс можно заменить AccuweatherModel
    void getWeather(String selectedCity, Period period) throws IOException;

    List<EntityWeather> getSavedToDBWeather();
}
