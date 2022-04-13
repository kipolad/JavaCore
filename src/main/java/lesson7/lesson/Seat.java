/**
 * Created by Yulya Telysheva
 */
package lesson7.lesson;

public class Seat extends CarElement {
    private Integer seatsCount;

    public Seat() {
        super();
    }

    public Seat(Integer seatsCount) {
        this.seatsCount = seatsCount;
        setName("Сиденье");
    }

    public Integer getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(Integer seatsCount) {
        this.seatsCount = seatsCount;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatsCount=" + seatsCount +
                '}';
    }
}
