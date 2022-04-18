/**
 * Created by Yulya Telysheva
 */
package lesson9.homework;

import java.util.List;

public class Student {
    private String getName;
    private List<Course> courses;

    public Student(String getName, List<Course> courses) {
        this.getName = getName;
        this.courses = courses;
    }

    public String getGetName() {
        return getName;
    }

    public void setGetName(String getName) {
        this.getName = getName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student " + getName + ".\n" + courses + "\n";
    }
}
