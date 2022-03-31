/**
 * Created by Yulya Telysheva
 */
package lesson4.lesson;

public class HashExamples {
    public static void main(String[] args) {
        System.out.println("test".hashCode());//hashCode вычисляется на основе полей
        System.out.println("test".hashCode());//Считается, что у разных объектов разный hashCode, но не всегда.
        System.out.println("test2".hashCode());//hashCode вычисляется по определенному алгоритму


    }
}
