package ru.aston.homework2.strategy;

public class CloseApplicationHandler implements UserChoiceHandler {
    @Override
    public void handle() {
        System.exit(0);
    }
}
