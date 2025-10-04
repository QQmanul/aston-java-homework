package homework1;

import homework1.model.Book;
import homework1.model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WorkingWithStudentCollections {

    private static List<Book> readBooks() {
        List<Book> books = new ArrayList<Book>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/books.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] parts = line.split(",");

                int pages = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);
                books.add(new Book(parts[0], pages, year));

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return books;
    }

    public static void main(String[] args) {

        List<Book> books = readBooks();

        Student ivan = new Student("Ivan", "Ivanov");
        Student petrov = new Student("Petrov", "Petrov");
        Student zworykin = new Student("Nikita", "Zworykin");

        List<Student> students = List.of(ivan, petrov, zworykin);

        Random random = new Random();
        for (Student student : students) {
            int bookAmount = random.nextInt(3) + 5;

            for (int i = 0; i < bookAmount; i++) {
                int bookIndex = random.nextInt(books.size());
                student.getBooks().add(books.get(bookIndex));
            }
        }

        Optional<Book> result = students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(Collection::stream)
                .distinct()
                .filter(b -> b.getYear() > 2000)
                .limit(3)
                .findFirst();

        result.ifPresentOrElse(
                b -> System.out.println("Book with year > 2000: " + b),
                () -> System.out.println("No book with year > 2000")
        );
    }
}
