/**
 * Created by Yulya Telysheva
 */
package lesson9;

import lesson9.lambda.Animal;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class FunctionalInterfacesExamples {
    public static void main(String[] args) {
        Predicate<Animal> animalPredicate = new Predicate<Animal>() {
            @Override
            public boolean test(Animal animal) {
                return animal.isCanRun();
            }
        };

        //Применить что-то к String, чтобы получился Integer
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };

        //Унарный оператор - когда есть один "х" из которого мы хотим получить что-то новое
        UnaryOperator<Integer> integerUnaryOperator = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer * integer;
            }
        };


    }
}
