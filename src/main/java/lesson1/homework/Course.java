/**
 * Created by Yulya Telysheva
 */
package lesson1.homework;

public class Course {
    String name;
    Trial[] trials;

    public Course(String name, Trial[] trials) {
        this.name = name;
        this.trials = trials;
    }

    public Trial[] getTrials() {
        return trials;
    }

    void doIt(Team team) {
        for (Participant participant : team.getParticipants()) {
            for (Trial trial : trials) {
                if (participant.getMaxRunningDistance() > trial.getDistance()) {
                    participant.setResult(participant.getResult() + 1);
                }
            }

        }
    }
}
