package ir.ac.kntu;

import java.util.Objects;

public class Teacher implements Cloneable {
    private String name;
    private Course course;
    private Book favouriteBook;

    public Teacher(String name, Course course, Book favouriteBook) {
        this.name = name;
        this.course = course;
        this.favouriteBook = favouriteBook;
    }

    public Book getFavouriteBook() {
        return favouriteBook;
    }

    public void setFavouriteBook(Book favouriteBook) {
        this.favouriteBook = favouriteBook;
    }

    @Override
    protected Teacher clone() throws CloneNotSupportedException {
        // TODO:
        //This Method Should Return a Deep Copy of this object
        //Note that primitive types and Immutable Objects do not require clone
        //Don't Forget that String Class is Immutable
        //Don't Forget to Delete The Line Below!
        throw new UnsupportedOperationException("Delete Me!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getName(), teacher.getName()) &&
                Objects.equals(getCourse(), teacher.getCourse()) &&
                Objects.equals(getFavouriteBook(), teacher.getFavouriteBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCourse(), getFavouriteBook());
    }
}
