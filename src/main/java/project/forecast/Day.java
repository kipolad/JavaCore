/**
 * Created by Yulya Telysheva
 */
package project.forecast;

public class Day {
    private String iconphrase;
    private boolean hasprecipitation;

    public Day() {
    }

    public Day(String iconPhrase, boolean hasPrecipitation) {
        this.iconphrase = iconPhrase;
        this.hasprecipitation = hasPrecipitation;
    }

    @Override
    public String toString() {
        if (hasprecipitation) {
            return "there will be precipitation: " + iconphrase;
        } else {
            return "precipitation is not expected: " + iconphrase;
        }
    }

    public String getIconphrase() {
        return iconphrase;
    }

    public void setIconphrase(String iconphrase) {
        this.iconphrase = iconphrase;
    }

    public boolean isHasprecipitation() {
        return hasprecipitation;
    }

    public void setHasprecipitation(boolean hasprecipitation) {
        this.hasprecipitation = hasprecipitation;
    }
}
