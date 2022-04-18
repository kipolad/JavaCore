/**
 * Created by Yulya Telysheva
 */
package lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreationExamples {
    public static void main(String[] args) {
        //Распечатать цифры от 1 до 10
        IntStream.range(1, 10)
                .forEach(System.out::print);

        //Собрать в коллекцию последовательность 10 чисел limit(10) с шагом + 5 (x -> x + 5)
        // и распечатать.
        System.out.println(Stream.iterate(5, x -> x + 5)
                .limit(10)
                .collect(Collectors.toList()));

        //Добавить в коллекцию 10 строк test с номерами по порядку
        List<String> stringList = new ArrayList<>();
        IntStream.range(1, 10)
                .forEach(i -> stringList.add("test" + i));
        System.out.println(stringList);
    }
}
