/**
 * Created by Yulya Telysheva
 */
package lesson3.lesson;

public class GenBox <T> {
    private T object; //T будет являться дженериком

    public GenBox(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "GenBox{" +
                "object=" + object +
                '}';
    }

    public static void main(String[] args) {
        GenBox<Integer> genBox1 = new GenBox<>(10);
        GenBox<Integer> genBox2 = new GenBox<>(20);

        int sum = genBox1.getObject() + genBox2.getObject();
        System.out.println(sum);

        // дженерики упрощают жизнь
        // нельзя в статическом методе возвращать Т
        // нельзя делать T value = new T();
        // нельзя сделать массив неопределенным T[] array = new T[10] т.к. java не знает, что скрывается под Т


    }
}
