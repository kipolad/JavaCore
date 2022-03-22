/**
 * Created by Yulya Telysheva
 */
package lesson1.homework;

public class Team {
    private String name;
    private Participant[] participants;

    public Team(String name, Participant[] participants) {
        this.name = name;
        this.participants = participants;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    void showTeamResult() {
        int result = 0;
        for (Participant participant : participants) {
            System.out.println("Участник - " + participant.getName() + ". Колличество заработанных баллов: " + participant.getResult());
            result += participant.getResult();
        }
        System.out.println("Команда: " + name + ". Колличество заработанных баллов: " + result);
    }
}
