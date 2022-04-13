/**
 * Created by Yulya Telysheva
 */
package lesson7.lesson.project.forecast;

public class Night {
    private String iconphrase;
    private boolean hasprecipitation;

    public Night() {
    }

    public Night(String iconPhrase, boolean hasPrecipitation) {
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
