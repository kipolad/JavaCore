/**
 * Created by Yulya Telysheva
 */
package lesson3.lesson;

public class BoxWithTwoGenerics <T, S> {
    private T obj1;
    private S obj2;

    public BoxWithTwoGenerics(T obj1, S obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public T getObj1() {
        return obj1;
    }

    public void setObj1(T obj1) {
        this.obj1 = obj1;
    }

    public S getObj2() {
        return obj2;
    }

    public void setObj2(S obj2) {
        this.obj2 = obj2;
    }

    @Override
    public String toString() {
        return "BoxWithTwoGenerics{" +
                "obj1=" + obj1 +
                ", obj2=" + obj2 +
                '}';
    }

    public static void main(String[] args) {
        BoxWithTwoGenerics<Integer, String> integerStringBoxWithTwoGenerics =
                new BoxWithTwoGenerics<>(145000000, "Население России");
        System.out.println(integerStringBoxWithTwoGenerics.getObj2() + " " + integerStringBoxWithTwoGenerics.getObj1());






    }
}
