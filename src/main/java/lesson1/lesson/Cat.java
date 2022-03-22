/**
 * Created by Yulya Telysheva
 */
package lesson1.lesson;

public class Cat extends Animal implements CanSwim {

    private int swimmingSpeed;

    public Cat(String name, String color, int age, boolean isWild) {
        super(name, color, age);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", age=" + getAge() +
                '}';
    }

    @Override
    public String voice() {
        return "Мяу!";
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

        System.out.println("Я котик " + getName() + "! Я плаваю со скоростью " + getSwimmingSpeed() + " м./мин. Я проплыл бассейн за " + result + " мин.");
        return result;
    }
}
