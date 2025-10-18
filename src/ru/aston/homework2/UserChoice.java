package ru.aston.homework2;

import java.util.HashMap;
import java.util.Map;

public enum UserChoice {
    ReadFile("1"),
    WriteFile("2"),
    CloseApplication("3");

    private final String userInput;

    UserChoice(String userInput) {
        this.userInput = userInput;
    }

    private static final Map<String, UserChoice> choiceMap = new HashMap<>();

    static {
        for (UserChoice choice : UserChoice.values()) {
            choiceMap.put(choice.userInput, choice);
        }
    }

    public String getUserInput() {
        return userInput;
    }

    public static UserChoice fromInput(String input) {
        return choiceMap.get(input);
    }
}
