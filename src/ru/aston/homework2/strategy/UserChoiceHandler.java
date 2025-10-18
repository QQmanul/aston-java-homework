package ru.aston.homework2.strategy;

import ru.aston.homework2.MyFileException;

public interface UserChoiceHandler {
    void handle() throws MyFileException;
}
