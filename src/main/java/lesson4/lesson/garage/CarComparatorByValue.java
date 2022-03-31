/**
 * Created by Yulya Telysheva
 */
package lesson4.lesson.garage;

import java.util.Comparator;

public class CarComparatorByValue implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        return car1.getValue() - car2.getValue();
    }
}
