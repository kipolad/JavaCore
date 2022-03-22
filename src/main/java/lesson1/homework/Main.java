/**
 * Created by Yulya Telysheva
 */
package lesson1.homework;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("Каракатицы", new Participant[]{new Participant("Квакушка", 50400),
                new Participant("Мяушка", 3250),
                new Participant("Гавгушка", 20300),
                new Participant("Игогушка", 6340)});
        Course course = new Course("Лига марафонцев", new Trial[]{new Trial("Бег на среднюю дистанцию", 5000),
                new Trial("Бег на длинную дистанцию", 50000)});
        course.doIt(team);
        team.showTeamResult();
    }
}
