package ir.ac.kntu;

import java.util.Objects;

public class Course /* TODO: Something is forgotten here! */ {
    private String subject;

    //this method returns a shallow copy
    @Override
    public Course clone() throws CloneNotSupportedException {
        return (Course) super.clone();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(getSubject(), course.getSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubject());
    }
}
