package ru.aston.homework2.strategy;

import ru.aston.homework2.MyFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileReaderHandler implements UserChoiceHandler {
    @Override
    public void handle() throws MyFileException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до файла:");

        String pathString = scanner.nextLine();
        Path path = Paths.get(pathString);

        if (Files.notExists(path)) {
            System.out.println("Этот файл не существует");
            return;
        }

        try (Stream<String> linesStream = Files.lines(path)) {
            linesStream.forEach(System.out::println);
        } catch (IOException e) {
            throw new MyFileException(e.getMessage());
        }
    }
}
