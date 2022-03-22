/**
 * Created by Yulya Telysheva
 */
package lesson1.lesson;

import lesson1.lesson.CanSwim;

public class Pool {

    private double length;

    public Pool(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }


    public void getTimeToOvercome(CanSwim swimmer) {
        swimmer.swim(this);
    }
}
