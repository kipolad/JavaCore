/**
 * Created by Yulya Telysheva
 */
package lesson4.lesson;

import java.util.Comparator;

public class CatComparatorByWeight implements Comparator<Cat> {
    @Override
    public int compare(Cat cat1, Cat cat2) {
        return cat1.getWeight() - cat2.getWeight();//компараторов можно создавать сколько угодно на любые поля
    }
}
