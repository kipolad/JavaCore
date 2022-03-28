/**
 * Created by Yulya Telysheva
 */
package lesson3.lesson.comparable;

public class Box2 implements Comparable<Box2> {
    //благодаря дженерику не нужно приводить к типу Box
    private int size;

    public Box2(int size) {
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
        return "Box2{" +
                "size=" + size +
                '}';
    }

    @Override
    public int compareTo(Box2 o) {
        return getSize() - o.getSize();
    }
}
