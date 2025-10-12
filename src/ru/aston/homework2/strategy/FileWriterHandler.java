package ru.aston.homework2.strategy;

import ru.aston.homework2.MyFileException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileWriterHandler implements UserChoiceHandler {

    @Override
    public void handle() throws MyFileException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до файла:");

        String pathString = scanner.nextLine();
        Path path = Paths.get(pathString);

        if (Files.notExists(path)) {
            System.out.println("Этот файл не существует! Создать? (Y/N)");

            String userChoice = scanner.nextLine().trim();

            if (!userChoice.equalsIgnoreCase("Y")) {
                return;
            }
        }

        System.out.println("Введите что будем записывать: ");
        String content = scanner.nextLine();

        try {
            Files.writeString(path, content, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new MyFileException(e.getMessage());
        }
    }
}
