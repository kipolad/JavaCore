/**
 * Created by Yulya Telysheva
 */
package lesson4.lesson.garage;

import lesson4.lesson.Cat;

public class Car extends Vehicle {

    private int value;

    public Car(String model, int power) {
        super(model, power);
    }

    public Car(String model, int power, int value) {
        super(model, power);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + getModel() + '\'' +
                ", power=" + getPower() +
                ", value=" + value +
                '}';
    }
}
