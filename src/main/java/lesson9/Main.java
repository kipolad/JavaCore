/**
 * Created by Yulya Telysheva
 */
package lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Oleg", 21, Person.Position.ENGINEER));
        personList.add(new Person("Anton", 54, Person.Position.MANAGER));
        personList.add(new Person("Oksana", 23, Person.Position.DIRECTOR));
        personList.add(new Person("Aleksey", 43, Person.Position.ENGINEER));
        personList.add(new Person("Andrey", 23, Person.Position.MANAGER));
        personList.add(new Person("Oleg", 32, Person.Position.ENGINEER));

        //Задача
        //Выбрать инженеров и отсортировать их по возрасту
        System.out.println(personList.stream()
                .filter(p -> p.getPosition() == Person.Position.ENGINEER)
                .sorted((p1, p2) -> p1.getAge() - p1.getAge())
                .collect(Collectors.toList()));

        //Сделать сумму по возрастам
        //map используется, чтобы перейти от одних сущностей к другим
        //Например от списка людей перейти к списку возрастов - за-map-ить
        //reduce превращает несколько объектов в 1
        Optional<Integer> sumAges = personList.stream()
                .map(p -> p.getAge())
                .reduce((p1, p2) -> p1 + p2);
        //sumAges никогда не упадет с проверкой isPresent (защита от Exceptions)
        if (sumAges.isPresent())
            System.out.println("Всё ok!");

        Stream<Integer> integerStream = Stream.of();
        Optional<Integer> optionalInteger = integerStream.reduce((a1, a2) -> a1 + a2);
        if (optionalInteger.isPresent())
            System.out.println(optionalInteger.get());

        //Задача
        //Выбрать что-то и распечатать уникальные значения (distinct())

        Stream.of("123", "1234", "234", "1234")
                .distinct()
                .forEach(p -> System.out.println(p));

        //Можно еще короче
        System.out.println(Stream.of("123", "1234", "234", "1234")
                .collect(Collectors.toSet()));

        System.out.println("---------------------");

        Integer[][] integers = new Integer[][]{{1, 2, 3}, {3, 4, 2}};

        Stream.of(integers)
                .flatMap(a -> Stream.of(a))
                .forEach(System.out::print);


    }
}
