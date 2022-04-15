/**
 * Created by Yulya Telysheva
 */
package project.forecast;

import java.util.List;

public class Weather {
    private String city;
    private List<DailyForecasts> dailyforecasts;

    public Weather() {
    }

    public Weather(List<DailyForecasts> dailyforecasts) {
        this.dailyforecasts = dailyforecasts;
    }

    public List<DailyForecasts> getDailyforecasts() {
        return dailyforecasts;
    }

    public void setDailyforecasts(List<DailyForecasts> dailyforecasts) {
        this.dailyforecasts = dailyforecasts;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Daily forecast for " + city + ": " + dailyforecasts;
    }


}
