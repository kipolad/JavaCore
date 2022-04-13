/**
 * Created by Yulya Telysheva
 */
package lesson7.lesson.project.forecast;

import java.util.List;

public class Weather {
    List<DailyForecasts> dailyforecasts;

    public Weather() {
    }

    public Weather(List<DailyForecasts> dailyforecasts) {
        this.dailyforecasts = dailyforecasts;
    }

    @Override
    public String toString() {
        return "Daily forecast: " + dailyforecasts;
    }

    public List<DailyForecasts> getDailyforecasts() {
        return dailyforecasts;
    }

    public void setDailyforecasts(List<DailyForecasts> dailyforecasts) {
        this.dailyforecasts = dailyforecasts;
    }
}
