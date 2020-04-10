package ir.ac.kntu;

import java.util.Objects;

public class Book implements Cloneable {
    private String name;
    private String subject;
    private String author;

    public Book(String name, String subject, String author) {
        this.name = name;
        this.subject = subject;
        this.author = author;
    }

    public Book() {
    }

    /**
     * @return A Shallow Copy
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        // TODO:
        //This method should return a Shallow Copy
        //Don't Forget to delete the line below!
        throw new UnsupportedOperationException("Delete me!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getName(), book.getName()) &&
                Objects.equals(getSubject(), book.getSubject()) &&
                Objects.equals(getAuthor(), book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSubject(), getAuthor());
    }
}
