/**
 * Created by Yulya Telysheva
 */
package lesson3.lesson;

public class Box {
    private Object object;

    public Box(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Box{" +
                "object=" + object +
                '}';
    }

    public static void main(String[] args) {
        Box box1 = new Box(5);
        Box box2 = new Box(10);

        System.out.println(box1.getObject().getClass()); //вернет класс Integer потому что в явном виде внутри Integer
        //int sum = box1.getObject() + box2.getObject();//так не получится, потому, что к любому Object нельзя применить +
        int sum = (Integer) box1.getObject() + (Integer) box2.getObject();//Берем ответственность на себя, лучше добавить проверку.
        System.out.println(sum);

        Box box3= new Box("test"); // нужно проверять на instanceOf
        if (box1.getObject() instanceof Integer && box3.getObject() instanceof Integer) {
            int sum1 = (Integer) box1.getObject() + (Integer) box3.getObject();
            System.out.println(sum1);
        }



    }
}
