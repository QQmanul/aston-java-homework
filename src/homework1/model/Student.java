package homework1.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private List<Book> books = new ArrayList<>();

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, List<Book> books) {
        this(firstName, lastName);
        this.books.addAll(books);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Hello my name is " + firstName + " " + lastName +
                " I have " + books.size() + " book(s)";
    }
}
