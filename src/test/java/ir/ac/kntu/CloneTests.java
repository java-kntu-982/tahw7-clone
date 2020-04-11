package ir.ac.kntu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author S.Shayan Daneshvar
 */
public class CloneTests {
    private Course course;
    private Book book;
    private Teacher teacher;

    private Class<Book> bookClass = Book.class;
    private Class<Course> courseClass = Course.class;
    private Class<Teacher> teacherClass = Teacher.class;
    private Class<Cloneable> cloneableClass = Cloneable.class;

    @BeforeEach
    public void prepare() {
        course = new Course();
        book = new Book();
        String name = "Ali";
        teacher = new Teacher(name, course, book);
    }

    @Test
    @DisplayName("Check Implementation Of Cloneable Interface")
    public void testImplementingCloneable() {
        Assertions.assertTrue(() -> cloneableClass.isAssignableFrom(bookClass),
                "Book does not implement cloneable");
        Assertions.assertTrue(() -> cloneableClass.isAssignableFrom(teacherClass),
                "Teacher does not implement cloneable");
        Assertions.assertTrue(() -> cloneableClass.isAssignableFrom(courseClass),
                "Course does not implement cloneable");
    }

    @Test
    @DisplayName("Shallow Clone - Course")
    public void testCourseShallowClone() throws CloneNotSupportedException {
        var courseClone = course.clone();
        Assertions.assertSame(courseClone.getSubject(), course.getSubject());
        Assertions.assertNotSame(courseClone, course, "Do not return the exact" +
                " same object - use the clone method");
    }

    @Test
    @DisplayName("Shallow Clone - Book")
    public void testBookShallowClone() throws CloneNotSupportedException {
        Book bookClone = (Book) book.clone();
        Assertions.assertSame(book.getSubject(), bookClone.getSubject(),
                "primitives do not require copy!");
        Assertions.assertSame(book.getAuthor(), bookClone.getAuthor(),
                "primitives do not require copy!");
        Assertions.assertSame(book.getName(), bookClone.getName(),
                "primitives do not require copy!");
        Assertions.assertNotSame(bookClone, book, "do not return the same " +
                "object! - use the clone method");
    }

    @Test
    @DisplayName("Deep Clone - Teacher")
    public void testTeacherDeepClone() throws CloneNotSupportedException {
        var teacherClone = teacher.clone();
        Assertions.assertEquals(teacher, teacherClone, "clones are not equal");
        Assertions.assertNotSame(teacher, teacherClone, "do not return " +
                "the exact same object - use the clone method");

        Assertions.assertEquals(teacher.getName(), teacherClone.getName(),
                "Teacher Class: Names are not equal");

        Assertions.assertEquals(teacherClone.getCourse(), teacher.getCourse()
                , "Teacher Class: Course is not equal");
        Assertions.assertNotSame(teacherClone.getCourse(),
                teacher.getCourse(), "Teacher Class: Course is not Cloned");

        Assertions.assertEquals(teacherClone.getFavouriteBook(),
                teacher.getFavouriteBook(), "Teacher Class: Book is not the" +
                        " same");
        Assertions.assertNotSame(teacherClone.getFavouriteBook(),
                teacher.getFavouriteBook(), "Teacher Class: Book is not " +
                        "Cloned");
    }
}
