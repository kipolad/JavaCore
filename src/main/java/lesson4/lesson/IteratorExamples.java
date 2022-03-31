/**
 * Created by Yulya Telysheva
 */
package lesson4.lesson;

import java.util.*;

public class IteratorExamples {
    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        System.out.println(integerArrayList);

        for (Integer integer : integerArrayList) {
            if (integer == 3) {
                integerArrayList.remove(new Integer(3));
            }
        }
        System.out.println(integerArrayList);

        HashMap<String, Integer> integerHashMap = new HashMap<>();

        integerHashMap.put("test1", 4);
        integerHashMap.put("test2", 4);
        integerHashMap.put("test3", 4);

        System.out.println(integerHashMap);

        Iterator<Map.Entry<String, Integer>> iterator = integerHashMap.entrySet().iterator();
        //Взяли HashMap и каждой паре присваиваем итератор.
        // Итератор пройдется по списку и удалит те элементы, которые не нужны.

        while (iterator.hasNext()) {
            String key = iterator.next().getKey();
            System.out.println(key);
            if (key.equals("test3")) {
                iterator.remove();
            }
        }
        System.out.println(integerHashMap);
    }
}
