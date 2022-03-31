/**
 * Created by Yulya Telysheva
 */
package lesson4.lesson.garage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> garage = new ArrayList<>();

        Bike bike = new Bike("Ява", 20);
        Car car = new Car("Renault", 100);

        garage.add(bike);
        garage.add(car);

        System.out.println("Индекс ячейки, в которой хранится car: " + garage.indexOf(car));

        Car car1 = new Car("BMW", 120);
        garage.add(car1);

        //отсортировать гараж
        Collections.sort(garage);//Сделать имплемент Comparable в Vehicle по полю power
        System.out.println("Отсортировали гараж по power: " + garage);

        ArrayList<Car> carArrayList = new ArrayList<>(Arrays.asList(car, car1, new Car("LADA", 80, 8)));
        Collections.sort(carArrayList);//сортируется по compareTo
        System.out.println("Отсортировали машины по power: " + carArrayList);

        //Можно сделать так
        //Collections.sort(carArrayList, new CarComparatorByValue());
        //а можно так
        carArrayList.sort(new CarComparatorByValue());//сортируется по Comparator<Car>
        System.out.println("Отсортировали машины по value: " + carArrayList);

        Collections.reverse(carArrayList);
        System.out.println("Список машин в обратном порядке: " + carArrayList);
    }
}
