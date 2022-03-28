/**
 * Created by Yulya Telysheva
 */
package lesson3.homework;

import java.util.ArrayList;
import java.util.Collections;

public class Box <T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public Box() {
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    double getWeight() {
        double sum = 0;
        for (T fruit : fruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    boolean compare(Box<?> box) {
        return (this.getWeight() - box.getWeight()) == 0;
    }

    void addFruit (T fruit) {
        this.getFruits().add(fruit);
    }

    void takeOutTheFruit(Box<T> box) {
        for (T fruit : this.getFruits()) {
            box.getFruits().add(fruit);
        }
        this.getFruits().removeAll(this.getFruits());
    }

    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.getFruits().add(new Apple(5.5));
        appleBox1.getFruits().add(new Apple(7.1));
        appleBox1.getFruits().add(new Apple(4.9));

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.getFruits().add(new Apple(5.5));
        appleBox2.getFruits().add(new Apple(7.1));
        appleBox2.getFruits().add(new Apple(4.9));

        Box<Orange> orangeBox = new Box<>();
        orangeBox.getFruits().add(new Orange(12.1));
        orangeBox.getFruits().add(new Orange(9.1));
        orangeBox.getFruits().add(new Orange(8.0));

        System.out.println("Вес коробки с яблоками № 1: " + appleBox1.getWeight());
        System.out.println("Вес коробки с яблоками № 2: " + appleBox2.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        orangeBox.addFruit(new Orange(11.1));
        System.out.println("Добавили апельсин в коробку: " + orangeBox.getWeight());

        System.out.println("Коробки весят одинаково? "+ appleBox1.compare(orangeBox));
        System.out.println("Коробки с яблоками весят одинаково? " + appleBox1.compare(appleBox2));

        System.out.println("А теперь пересыпем яблоки из 2 в 1 коробку!");
        appleBox2.takeOutTheFruit(appleBox1);
        System.out.println("Вес коробки с яблоками № 1: " + appleBox1.getWeight());
        System.out.println("Вес коробки с яблоками № 2: " + appleBox2.getWeight());

    }
}
