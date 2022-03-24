/**
 * Created by Yulya Telysheva
 */
package lesson2.lesson;
//свои Exception лучше наследовать от обычных Exception,
// т.к. RuntimeException могут не обработать (не заметят)
public class OneOrMoreRectangleSideIsNegativeException extends Exception {
    //можно оставить так без ничего, можно написать конструктор
    public OneOrMoreRectangleSideIsNegativeException(String message) {
        super(message); // у Exception есть такой конструктор, поэтому наш конструктор
        // принимает конструктор родителя.
    }
}
