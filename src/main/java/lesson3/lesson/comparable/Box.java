/**
 * Created by Yulya Telysheva
 */
package lesson3.lesson.comparable;

import java.util.Arrays;

public class Box implements Comparable {
    //Задача: сравнить две коробки по размеру
    private int size;

    public Box(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Box{" +
                "size=" + size +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.getSize() - ((Box) o).getSize();//возвращает int тк внутри вычитаются объекты. Получается отрицательное число, положительное и 0.
        //((Box) o).getSize() - this.getSize(); отсортирует от большего к меньшему
    }

    public static void main(String[] args) {
        Box box1 = new Box(50);
        Box box2 = new Box(100);

        System.out.println(box1.compareTo(box2));

        Box[] boxes = {new Box(4), new Box(29), new Box(202), new Box(58)};
        Arrays.sort(boxes); //Если бы не было compare, то java не смогла бы сравнивать коробки
        System.out.println(Arrays.toString(boxes));
    }


}
