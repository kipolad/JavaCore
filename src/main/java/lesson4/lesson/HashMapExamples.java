/**
 * Created by Yulya Telysheva
 */
package lesson4.lesson;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapExamples {
    //В HashMap хранятся пары ключ - значение
    //Если значения хэшкодов разные, то значения попадают в разные ячейки, если одинаковые, то в одну корзину
    //и от первого элемента тянется ссылка ко второму и так далее. Но если значение хэша и само значение ключа одинаковы,
    //то заменяется само значение узла.
    public static void main(String[] args) {
        HashMap<Integer, String> passports = new HashMap<>();//Начальный размер можно не задавать.
        passports.put(1234, "Ирина");//Ключ вычисляется по хэшу
        passports.put(2234, "Андрей");
        passports.put(11234, "Антон");
        passports.put(12134, "Оксана");
        System.out.println("Порядок не сохраняется: " + passports);

        passports.remove(11234);
        System.out.println(passports);

        System.out.println(passports.get(2234));

        //HashMap<String, ArrayList<String>> arrayListHashMap = new HashMap<>();

        //passports.keySet() Получить множество ключей
//        for (Integer key : passports.keySet()) {
//            if (key == 1234) {
//                passports.remove(key);
//            }
//        }
        //Нельзя одновременно идти по коллекции и изменять ее. Потому что мы меняем структуру по которой пытаемся пройти.
        System.out.println(passports);
        //passports.entrySet() пары ключей значений.
        //passports.values() Получить множество значений.


    }
}
