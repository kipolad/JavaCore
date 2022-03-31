/**
 * Created by Yulya Telysheva
 */
package lesson4.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CountVerbs {
    public static void main(String[] args) {
        //Задание №1.

        ArrayList<String> verbs = new ArrayList<>(Arrays.asList("ходить", "бегать", "прыгать", "обнимать", "смотреть",
                "лежать", "лететь", "сидеть", "стоять", "лететь", "моргать", "радовать", "обнимать", "любить", "обнимать",
                "топать", "хлопать", "ходить", "прыгать", "прыгать"));
        System.out.println("Количество глаголов в массиве verbs: " + verbs.size());

        HashSet<String> verbsHashSet = new HashSet<>(verbs);
        System.out.println("Количество уникальных слов: " + verbsHashSet.size());

        printCountVerbs(verbs);

        System.out.println("---------------------------");
    }

    static void printCountVerbs(ArrayList<String> array) {
        int count = 0;
        HashSet<String> arrayHashSet = new HashSet<>(array);
        for (String str : arrayHashSet) {
            for (String strFromArray : array) {
                if (str.equals(strFromArray)) {
                    count++;
                }
            }
            System.out.println(str + ": " + count);
            count = 0;
        }
    }
}
