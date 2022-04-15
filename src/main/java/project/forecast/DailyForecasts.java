/**
 * Created by Yulya Telysheva
 */
package project.forecast;

public class DailyForecasts {
    private String date;
    private Temperature temperature;
    private Day day;
    private Night night;

    public DailyForecasts() {
    }

    public DailyForecasts(String date, Temperature temperature, Day day, Night night) {
        this.date = date;
        this.temperature = temperature;
        this.day = day;
        this.night = night;
    }

    @Override
    public String toString() {
        return "\ndate: " + date +
                ", \ntemperature:\n" + temperature +
                ", \nday\n" + day +
                ", \nnight\n" + night;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Night getNight() {
        return night;
    }

    public void setNight(Night night) {
        this.night = night;
    }
}
