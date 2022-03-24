/**
 * Created by Yulya Telysheva
 */
package lesson2.lesson;
// Нельзя всю программу обернуть в try catch, лучше делать проверки
public class UncheckedException {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        if (b != 0) {
            int c = a / b;
        }
        //Здесь будет unchecked Exception
        //try {
        //    int c = a / b;
        //} catch (ArithmeticException e) {
        //    System.out.println("Exception!!!");
        //}

        String[] array = {"sdf", "kkdkj"};
        //String string = array[2]; Здесь будет unchecked Exception - ArrayIndexOfBoundException наследник RuntimeException
        if (array.length >= 3) {
            String string = array[2];
            System.out.println(string);
        }

        System.out.println("Я работаю!");

    }
}
