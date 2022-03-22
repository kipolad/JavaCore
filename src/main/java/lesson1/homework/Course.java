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
        for (int i = 5; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Начали!");
        for (Participant participant : team.getParticipants()) {
            for (Trial trial : trials) {
                if (participant.getMaxRunningDistance() > trial.getDistance()) {
                    participant.setResult(participant.getResult() + 1);
                }
            }
        }
        System.out.println("Соревнования прошли успешно!");
    }
}
