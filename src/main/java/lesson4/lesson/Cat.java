/**
 * Created by Yulya Telysheva
 */
package lesson4.lesson;

import java.util.*;

public class Cat implements Comparable<Cat> {
    private String name;
    private int age;
    private int weight;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Cat cat) {
        return age - cat.getAge();
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && weight == cat.weight && Objects.equals(name, cat.name);
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat("Testik", 1, 3);
        Cat cat2 = new Cat("Testik", 1, 4);
        Cat cat3 = new Cat("Testikoshka", 1, 100);
        Cat cat4 = new Cat("Testikoshka", 7, 101);

        System.out.println( cat1.hashCode() + " hashCode по имени и возрасту");
        System.out.println(cat2.hashCode());
        System.out.println(cat3.hashCode());
        System.out.println(cat4.hashCode());

        System.out.println("--------------------");

        HashSet<Cat> catHashSet = new HashSet<>(Arrays.asList(cat1, cat2, cat3, cat4));
        System.out.println(catHashSet);

        HashSet<Integer> integerHashSet = new HashSet<>(Arrays.asList(1, 400, 3, 5, 5, 16, 8, 7, 9));
        System.out.println("HashSet не сортирует список" + integerHashSet);

        LinkedHashSet<Integer> integerLinkedHashSet = new LinkedHashSet<>(Arrays.asList(1, 4, 3, 5, 5, 6, 8, 7, 9));//хранит порядок, в котором вставляли
        System.out.println("LinkedHashSet выводит всё на своих местах" + integerLinkedHashSet);

        TreeSet<Integer> integerTreeSet = new TreeSet<>(Arrays.asList(1, 4, 3, 5, 5, 60, 8, 7, 9)); //бинарное дерево. Множество объектов хранится в отсортированном виде
        System.out.println("TreeSet всё отсортирует" + integerTreeSet);

        TreeSet<Cat> catTreeSet = new TreeSet<>(Arrays.asList(cat1, cat2, cat3, cat4));//java по умолчанию не умеет сортировать котиков
        System.out.println("Действует compareTo по возрасту " + catTreeSet);

        System.out.println("-----------------");

        TreeSet<Cat> catTreeSet1 = new TreeSet<>(new CatComparatorByWeight());//Создаем компаратор - критерий, по которому сравнивать объекты. С критерием по весу.
        catTreeSet1.add(cat1);
        catTreeSet1.add(cat2);
        catTreeSet1.add(cat3);
        catTreeSet1.add(cat4);//если будут коты с одинаковым весом, то их не добавит в сет

        System.out.println(catTreeSet1);

    }
}
