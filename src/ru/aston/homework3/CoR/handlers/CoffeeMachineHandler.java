package ru.aston.homework3.CoR.handlers;

import ru.aston.homework3.builder.CoffeeType;

public interface CoffeeMachineHandler {
    void setNext(CoffeeMachineHandler handler);

    void handler(CoffeeType coffee);
}
