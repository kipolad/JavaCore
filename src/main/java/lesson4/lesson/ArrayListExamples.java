/**
 * Created by Yulya Telysheva
 */
package lesson4.lesson;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListExamples {
    public static void main(String[] args) {
        //ArrayList integerArrayList = new ArrayList();//Создается массив длины 10. Но можно задать длину в ()
        ArrayList<Integer> integerArrayList = new ArrayList<>(100);
        integerArrayList.add(123);
        integerArrayList.add(456);
        integerArrayList.add(789);
        integerArrayList.add(123);

        System.out.println(integerArrayList);

        integerArrayList.remove(new Integer(123));//Удалится первый элемент, а остальные сдвинулись
        System.out.println(integerArrayList);
        System.out.println(integerArrayList.size());

        integerArrayList.set(1, 999);//замена значения
        System.out.println(integerArrayList);

        System.out.println("-------------------");

        ArrayList<Integer> integerArrayList1 = new ArrayList<>(Arrays.asList(123, 456)); //Сразу добавит два числа в коллекцию
        System.out.println(integerArrayList1);
        integerArrayList.removeAll(integerArrayList1);//Из integerArrayList удалили все элементы, которые есть в новой коллекции
        System.out.println(integerArrayList);

        integerArrayList.addAll(integerArrayList1);//Можно указать индекс с которого добавлять
        System.out.println(integerArrayList1);

        System.out.println(integerArrayList.contains(999));

    }
}
