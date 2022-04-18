/**
 * Created by Yulya Telysheva
 */
package lesson9.homework;

public class Course {
    String course;

    public Course(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Course " + course;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Course) {
            return ((Course) obj).getCourse().equals(this.getCourse());
        }
        return false;
    }
}
