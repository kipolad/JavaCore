/**
 * Created by Yulya Telysheva
 */
package project.forecast;

public class Minimum {
    private double value;
    private String unit;

    public Minimum() {
    }

    public Minimum(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public String toString() {
        int temp = (int) ((value - 32) / 1.8);
        return temp + " " + "C";
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
