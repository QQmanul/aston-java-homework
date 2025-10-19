package ru.aston.homework3.CoR.handlers;

import ru.aston.homework3.builder.CoffeeType;

import java.util.logging.Logger;

public abstract class BaseCoffeeMachineHandler implements CoffeeMachineHandler {
    protected final Logger logger;
    protected CoffeeMachineHandler nextHandler;

    public BaseCoffeeMachineHandler() {
        this.logger = Logger.getLogger(this.getClass().getName());
    }

    public BaseCoffeeMachineHandler(CoffeeMachineHandler handler) {
        this();
        nextHandler = handler;
    }

    @Override
    public void setNext(CoffeeMachineHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handler(CoffeeType coffee) {
        if (nextHandler != null) {
            nextHandler.handler(coffee);
        }
    }
}
