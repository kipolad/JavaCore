/**
 * Created by Yulya Telysheva
 */
package lesson7.lesson;

public class CarElement {
    private String name;

    public CarElement() {
    }

    public CarElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CarElement{" +
                "name='" + name + '\'' +
                '}';
    }
}
