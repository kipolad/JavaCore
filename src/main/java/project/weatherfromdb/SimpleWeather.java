/**
 * Created by Yulya Telysheva
 */
package project.weatherfromdb;

public class SimpleWeather {
    private String city;
    private String localdate;
    private double temperatureMax;
    private double temperatureMin;
    private String dayPhrase;
    private String nightPhrase;


    public SimpleWeather() {
    }

    public SimpleWeather(String city, String localdate, double temperatureMax, double temperatureMin, String dayPhrase, String nightPhrase) {
        this.city = city;
        this.localdate = localdate;
        this.temperatureMax = temperatureMax;
        this.temperatureMin = temperatureMin;
        this.dayPhrase = dayPhrase;
        this.nightPhrase = nightPhrase;
    }

    public double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public String getDayPhrase() {
        return dayPhrase;
    }

    public void setDayPhrase(String dayPhrase) {
        this.dayPhrase = dayPhrase;
    }

    public String getNightPhrase() {
        return nightPhrase;
    }

    public void setNightPhrase(String nightPhrase) {
        this.nightPhrase = nightPhrase;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocaldate() {
        return localdate;
    }

    public void setLocaldate(String localdate) {
        this.localdate = localdate;
    }

    public double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    @Override
    public String toString() {
        return "In city " + city + ", on " + localdate + ", temperatureMax: " + temperatureMax +
                ", temperatureMin: " + temperatureMin +
                ". Day precipitation: " + dayPhrase + ", night precipitation: " + nightPhrase + ".\n";
    }
}
