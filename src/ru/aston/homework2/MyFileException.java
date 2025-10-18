package ru.aston.homework2;

import java.io.IOException;

public class MyFileException extends IOException {
    public MyFileException(String message) {
        super("Теперь это моя ошибка ->" + message);
    }
}
