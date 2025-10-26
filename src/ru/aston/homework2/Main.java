package ru.aston.homework2;

import ru.aston.homework2.strategy.CloseApplicationHandler;
import ru.aston.homework2.strategy.FileReaderHandler;
import ru.aston.homework2.strategy.FileWriterHandler;
import ru.aston.homework2.strategy.UserChoiceHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<UserChoice, UserChoiceHandler> handlerMap = new HashMap<>();

        handlerMap.put(UserChoice.ReadFile, new FileReaderHandler());
        handlerMap.put(UserChoice.WriteFile, new FileWriterHandler());
        handlerMap.put(UserChoice.CloseApplication, new CloseApplicationHandler());

        while (true) {
            try {
                printMenu();
                String input = getUserInput(scanner);
                UserChoice choice = UserChoice.fromInput(input);

                if (choice == null) {
                    throw new IllegalArgumentException("Некорекктый ввод в меню");
                }

                UserChoiceHandler handler = handlerMap.get(choice);

                if (handler == null) {
                    throw new IllegalArgumentException("К данному выбору не привязан обработчик");
                }

                handler.handle();
            } catch (MyFileException | IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    @org.jetbrains.annotations.NotNull
    private static String getUserInput(Scanner scanner) {
        if (scanner == null) {
            throw new NullPointerException();
        }
        return scanner.nextLine().trim();
    }

    private static void printMenu() {
        System.out.printf("%s - Прочитать файл \r\n", UserChoice.ReadFile.getUserInput());
        System.out.printf("%s - Записать в файл \r\n", UserChoice.WriteFile.getUserInput());
        System.out.printf("%s - Выход \r\n", UserChoice.CloseApplication.getUserInput());
    }
}
