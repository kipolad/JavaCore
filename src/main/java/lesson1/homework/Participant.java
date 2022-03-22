/**
 * Created by Yulya Telysheva
 */
package lesson1.homework;

public class Participant {
    private String name;
    private int maxRunningDistance;
    int result;

    public Participant(String name, int maxRunningDistance) {
        this.name = name;
        this.maxRunningDistance = maxRunningDistance;
    }

    public int getMaxRunningDistance() {
        return maxRunningDistance;
    }


    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public String getName() {
        return name;
    }
}
