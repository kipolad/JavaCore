/**
 * Created by Yulya Telysheva
 */
package lesson3.lesson;

import java.util.Arrays;

public class NumbersBox <T extends Number> {
    // под Т будут только числа, теперь мы можем создавать массив типа Т
    private T[] array;

    public NumbersBox(T... array) { //под ... скрывается любое количество переменных типа Т
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "NumbersBox{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public double calcAverage() {
        double sum = 0.0;
        for (T num : array) {
            sum += num.doubleValue();//Приводим к типу число и складываем
        }
        return sum / array.length;
    }

    public boolean isSameAverage(NumbersBox<?> boxToCompare) {//вместо ? может быть другой числовой тип наследник от Number, если оставит Т, то второй массив должен быть такого же типа как и 1 массив.
        return Math.abs(calcAverage() - boxToCompare.calcAverage()) < 0.0001;
    }

    //метод, который будет возвращать 1 элемент коробки
    public static <U extends Number> U getFirstElement(NumbersBox<U> numbersBox) {
        return numbersBox.getArray()[0];//в статическом контексте мы пользуемся возможностями класса и вместо Т можно использовать другие буквы, чтобы было независимо от того, чем пользуется класс
    }

    public static void main(String[] args) {
        NumbersBox<Integer> integerNumbersBox = new NumbersBox<>(1, 2, 3, 4, 5, 6, 7);
        System.out.println(integerNumbersBox.calcAverage());

        NumbersBox<Double> doubleNumbersBox1 = new NumbersBox<>(15.0, 4.0, 2.6, 8.9);
        System.out.println(integerNumbersBox.isSameAverage(doubleNumbersBox1));

        System.out.println(getFirstElement(doubleNumbersBox1));
        System.out.println(getFirstElement(integerNumbersBox));//используем статический метод без привязки к объекту
    }
}
