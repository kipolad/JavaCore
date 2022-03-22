/**
 * Created by Yulya Telysheva
 */
package lesson1.lesson;

import lesson1.lesson.Animal;
import lesson1.lesson.CanSwim;
import lesson1.lesson.Pool;

public class Wolf extends Animal implements CanSwim {

    private int swimmingSpeed;

    public Wolf(String name, String color, int age) {
        super(name, color, age);
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", age=" + getAge() +
                '}';
    }

    @Override
    public String voice() {
        return "Аууууу!";
    }

    public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    public int getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public double swim(Pool pool) {
        int resultWithoutPoint = (int) (pool.getLength() / (swimmingSpeed * 1.0) * 100);
        double result = (resultWithoutPoint) / 100.0;

        System.out.println("Я волк " + getName() + "! Я плаваю со скоростью " + getSwimmingSpeed() + " м./мин. Я проплыл бассейн за " + result + " мин.");
        return result;
    }
}
