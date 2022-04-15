/**
 * Created by Yulya Telysheva
 */
package project.forecast;

public class Temperature {
    private Minimum minimum;
    private Maximum maximum;

    public Temperature() {
    }

    public Temperature(Minimum minimum, Maximum maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "minimum: " + minimum +
                ", maximum: " + maximum;
    }

    public Minimum getMinimum() {
        return minimum;
    }

    public void setMinimum(Minimum minimum) {
        this.minimum = minimum;
    }

    public Maximum getMaximum() {
        return maximum;
    }

    public void setMaximum(Maximum maximum) {
        this.maximum = maximum;
    }
}
