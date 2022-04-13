/**
 * Created by Yulya Telysheva
 */
package lesson7.lesson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Car car = new Car("Белый", "Lada");
        //Перевести объект в строку формата JSON
        String carFromJSON = objectMapper.writeValueAsString(car);

        System.out.println("carFromJSON: " + carFromJSON);

        //Восстановить из стринги обратно

        Car car1 = objectMapper.readValue(carFromJSON, Car.class);
        System.out.println("toString: " + car1);//нет дефолтного конструктора
        // objectMapper какой из конструкторов использовать, поэтому она берет дефолтный конструктор
        // без параметров. Создает пустой объект класса Car и все напарсенные параметры проставляет сетторами
        //Нужно добавить в Car конструктор без параметров

        System.out.println("-------------------------------------------");

        List<Car> carList = new ArrayList<>(Arrays.asList(new Car("Black", "Mercedes"),
                new Car("Red", "Renault")));
        System.out.println("toString ArrayList<Car> до преобразования: " + carList);

        //Переводим ArrayList в JSON
        String carsAsJSON = objectMapper.writeValueAsString(carList);
        System.out.println("ArrayList<Car> преобразованный в JSON: " + carsAsJSON);

        //Восстановление из JSON списка машин
        //ArrayList - это обертка над объектами, поэтому по-обычному сделать не получится...
        List<Car> carsFromJSON = objectMapper.readValue(carsAsJSON, new TypeReference<ArrayList<Car>>() {
        });
        System.out.println("Восстановление ArrayList<Car> из JSON: " + carsFromJSON);
        System.out.println("-------------------------------------------");

        //Если нам пришел JSON в другом виде, с дополнительными параметрами
        String jsonCarAfterUpdate = "{\"color\":\"Белый\",\"type\":\"Lada\",\"year\":\"2022\"}";
        //При восстановлении objectMapper не знает, что за новые свойства у машины year
        //Восстановить обычным способом не получится
        //Car carAfterUpdate = objectMapper.readValue(jsonCarAfterUpdate, Car.class);
        //Можно поменять конфигурацию objectMapper
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);//По умолчанию стоит true,
        // т.е. падает в несуществующих Property
        //Данный вариант хороший, но он опасен, т.к. мы можем не заметить, что изменилось
        //Car carAfterUpdate = objectMapper.readValue(jsonCarAfterUpdate, Car.class);//теперь работать будет
        //System.out.println(carAfterUpdate);

        //Есть более точный вариант: над названием класса Car добавить свойство
        // см. класс Car (@JsonIgnoreProperties(ignoreUnknown = true)) - интеграция не будет падать
        Car carAfterUpdate = objectMapper.readValue(jsonCarAfterUpdate, Car.class);//теперь работает
        System.out.println(carAfterUpdate);
        System.out.println("-------------------------------------------");

        //Теперь решили изменить название поля type на model
        String jsonCarAfterRefactoring = "{\"color\":\"Белый\",\"model\":\"Lada\"}";
        Car carAfterRefactor = objectMapper.readValue(jsonCarAfterRefactoring, Car.class);
        //Получился Car{color='Белый', type='null'} который благодаря игнору в классе Car не упал
        //Можно поставить аннотацию к полю type класса Car
        // @JsonProperty("model")
        // private String type;
        System.out.println(carAfterRefactor);//теперь type заполнилось на нужное значение
        System.out.println("-------------------------------------------");

        //В автомобиль добавили сиденье
        Car carWithSeat = new Car("Yellow", "Peugeot");
        carWithSeat.setSeat(new Seat(5));

        //Преобразуем в JSON
        String carWithSeatJSON = objectMapper.writeValueAsString(carWithSeat);
        System.out.println(carWithSeatJSON);

        Car carWithSeatFromJSON = objectMapper.readValue(carWithSeatJSON, Car.class);
        System.out.println(carWithSeatFromJSON);

    }
}
