/**
 * Created by Yulya Telysheva
 */
package lesson1.lesson;

import lesson1.lesson.Animal;
import lesson1.lesson.CanSwim;
import lesson1.lesson.Pool;

public class Turtle extends Animal implements CanSwim {

    private int swimmingSpeed;

    public Turtle(String name, String color, int age) {
        super(name, color, age);
    }

    @Override
    public String toString() {
        return "Turtle{" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", age=" + getAge() +
                '}';
    }

    @Override
    public String voice() {
        return "Пшшшшш!";
    }

    public double swim(Pool pool) {
        int resultWithoutPoint = (int) (pool.getLength() / (swimmingSpeed * 1.0) * 100);
        double result = (resultWithoutPoint) / 100.0;

        System.out.println("Я черепаха " + getName() + "! Я плаваю со скоростью " + getSwimmingSpeed() + " м./мин. Я проплыла бассейн за " + result + " мин.");
        return result;
    }

    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }
}
