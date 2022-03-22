package lesson1.lesson;

/**
 * Created by Yulya Telysheva
 */

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Мурзик", "white", 1, false);
        Cat cat1 = new Cat("Барсик", "white", 1, true);
        Cat cat2 = new Cat("Карандаш", "black", 2,true);
        Wolf wolf = new Wolf("Капитошка", "black", 2);
        Turtle turtle = new Turtle("Тратила", "blue", 100);

        Pool pool = new Pool(50.0);
        cat.setSwimmingSpeed(10);
        cat1.setSwimmingSpeed(15);
        cat2.setSwimmingSpeed(16);
        wolf.setSwimmingSpeed(30);
        turtle.setSwimmingSpeed(11);

        CanSwim[] swimmers = {cat, cat1, cat2, wolf, turtle};
        for (CanSwim swimmer: swimmers) {
            pool.getTimeToOvercome(swimmer);
        }
    }
}
