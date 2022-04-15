/**
 * Created by Yulya Telysheva
 */
package lesson8.project.forecast;

public class Maximum {
    private double value;
    private String unit;

    public Maximum() {
    }

    public Maximum(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return valueConvertToCelsius() + " " + "C";
    }

    int valueConvertToCelsius() {
        return (int) ((value - 32) / 1.8);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
