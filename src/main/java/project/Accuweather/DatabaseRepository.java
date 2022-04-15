/**
 * Created by Yulya Telysheva
 */
package project.Accuweather;

import project.forecast.Weather;
import project.weatherfromdb.SimpleWeather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepository {
    private final String getWeather = "select * from weather";
    private static final String DB_PATH = "jdbc:sqlite:C:\\Users\\Jalexy\\Desktop\\SQLite\\geekbrains.db";

    //блок static при запуске main выполнится 1 раз
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWeatherToDatabase(Weather weather) {
        boolean result = false;
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            String insertWeather = "insert into weather (city, localdate, temperature_max, temperature_min, day_precipitation, night_precipitation) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            for (int i = 0; i < weather.getDailyforecasts().size(); i++) {
                saveWeather.setString(1, weather.getCity());
                saveWeather.setString(2, weather.getDailyforecasts().get(i).getDate());
                saveWeather.setDouble(3, weather
                        .getDailyforecasts()
                        .get(i)
                        .getTemperature()
                        .getMaximum()
                        .getValue());
                saveWeather.setDouble(4, weather
                        .getDailyforecasts()
                        .get(i)
                        .getTemperature()
                        .getMinimum()
                        .getValue());
                saveWeather.setString(5, weather
                        .getDailyforecasts()
                        .get(i)
                        .getDay()
                        .getIconphrase());
                saveWeather.setString(6, weather
                        .getDailyforecasts()
                        .get(i)
                        .getNight()
                        .getIconphrase());
                saveWeather.execute();//saveWeather.execute() возвращает boolean
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<SimpleWeather> getSavedToDBWeather() {
        List<SimpleWeather> weatherList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from weather");
            while (resultSet.next()) {
                weatherList.add(new SimpleWeather(resultSet.getString("city"),
                        resultSet.getString("localdate"),
                        resultSet.getInt("temperature_max"),
                        resultSet.getInt("temperature_min"),
                        resultSet.getString("day_precipitation"),
                        resultSet.getString("night_precipitation")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weatherList;
    }
}
