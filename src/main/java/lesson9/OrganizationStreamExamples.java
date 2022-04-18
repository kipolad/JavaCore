/**
 * Created by Yulya Telysheva
 */
package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrganizationStreamExamples {
    public static void main(String[] args) {
        List<Organization> organizations = new ArrayList<>();
        organizations.add(new Organization(1, "Yandex", Arrays.asList(
                new Worker("Oleg", 55, 100, "Engineer"),
                new Worker("Anton", 25, 120, "Manager"),
                new Worker("Elena", 35, 140, "Engineer"))));
        organizations.add(new Organization(2, "Sber", Arrays.asList(
                new Worker("Oleg", 55, 100, "Engineer"),
                new Worker("Dmitry", 25, 160, "Manager"),
                new Worker("Elena", 35, 123, "Engineer"),
                new Worker("Dmitry", 63, 1140, "Director"),
                new Worker("Oksana", 12, 1450, "Engineer"))));
        organizations.add(new Organization(1, "Mail", Arrays.asList(
                new Worker("Oleg", 55, 100, "Engineer"),
                new Worker("Anton", 41, 120, "Manager"),
                new Worker("Kseniya", 124, 140, "Engineer"))));

        //Задача 1.
        //Вернуть уникальные имена сотрудников компании, где > 3 сотрудников
        //filter - отфильтровали организации, где более 3 сотрудников
        //map - перешли от списка организаций к списку сотрудников
        //flatmap - перешли к единому списку сотрудников
        //map - перешли от списка сотрудников к списку имен сотрудников
        //collect - сформировать в коллекцию
        System.out.println(organizations.stream()
                .filter(o -> o.getWorkers().size() > 3)
                .map(o -> o.getWorkers())
                .flatMap(workers -> workers.stream())
                .map(w -> w.getName())
                .collect(Collectors.toSet()));
        System.out.println("-----------------------");

        //Задача 2.
        //Создать Map, где ключ - название должности, значение - список сотрудников на этой должности.
        System.out.println(
                organizations.stream()
                        .map(o -> o.getWorkers())
                        .flatMap(w -> w.stream())
                        .collect(Collectors.groupingBy(w -> w.getPosition())));
        System.out.println("-----------------------");

        //Задача 3.
        //Создать Map, где ключ - должность, значение - средняя зарплата.
        Map<String,Double> salaryRating = organizations.stream()
                .map(o -> o.getWorkers())
                .flatMap(w -> w.stream())
                .collect(Collectors.groupingBy(w -> w.getPosition(),
                        Collectors.averagingDouble((f -> f.getSalary()))));
        System.out.println(salaryRating);
    }
}
