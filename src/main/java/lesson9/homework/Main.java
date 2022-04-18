/**
 * Created by Yulya Telysheva
 */
package lesson9.homework;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nick", Arrays.asList(
                new Course("Math"),
                new Course("Web"),
                new Course("HTML"))));
        students.add(new Student("Artem", Arrays.asList(new Course("System"))));
        students.add(new Student("Alex", Arrays.asList(
                new Course("Math"),
                new Course("Java"),
                new Course("Kotlin"),
                new Course("Compose"))));
        students.add(new Student("July", Arrays.asList(
                new Course("Math"),
                new Course("QA mobile"),
                new Course("Web testing"),
                new Course("Test design"),
                new Course("Java for testers"))));

        //Задание № 1.
        //Написать функцию, принимающую список Student
        //и возвращающую список уникальных курсов, на которые подписаны студенты.

        System.out.println(coursesList(students));
        System.out.println("--------------------------");

        //Задание № 2.
        //Написать функцию, принимающую на вход список Student и возвращающую список
        // из трех самых любознательных (любознательность определяется количеством курсов).

        System.out.println(studentsRating(students));
        System.out.println("--------------------------");

        //Задание № 3.
        //Написать функцию, принимающую на вход список Student и экземпляр Course,
        //возвращающую список студентов, которые посещают этот курс.
        System.out.println(studentsAttendingACourse(students, new Course("Math")));


    }

    static Set<String> coursesList(List<Student> students) {
        return students.stream()
                .map(Student::getCourses)
                .flatMap(Collection::stream)
                .map(Course::getCourse)
                .collect(Collectors.toSet());
    }

    static List<Student> studentsRating(List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList());
    }

    static List<Student> studentsAttendingACourse(List<Student> students, Course course) {
        return students.stream()
                .filter(student -> student.getCourses().contains(course))
                .toList();

    }
}
