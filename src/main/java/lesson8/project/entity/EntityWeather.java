/**
 * Created by Yulya Telysheva
 */
package lesson8.project.entity;

public class EntityWeather {
    //создаем класс для перевода его объектов в таблицу БД
    private String city;
    private String localDate;
    private double temperature;

    public EntityWeather(String city, String localDate, double temperature) {
        this.city = city;
        this.localDate = localDate;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "EntityWeather{" +
                "city='" + city + '\'' +
                ", localDate='" + localDate + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
