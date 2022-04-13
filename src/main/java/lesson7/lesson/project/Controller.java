/**
 * Created by Yulya Telysheva
 */
package lesson7.lesson.project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    //будет проверять, что ввел пользователь
    private WeatherModel weatherModel = new AccuweatherModel();
    //еще нужен словарь, чтобы распознавать команды от пользователя
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller() {
        variants.put(1, Period.NOW);
        variants.put(5, Period.FIVE_DAYS);
    }

    public void getWeather(String userInput, String selectedCity) throws IOException {
        Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)) {
            case NOW -> weatherModel.getWeather(selectedCity, Period.NOW);
            case FIVE_DAYS -> weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);
        }
    }
}
