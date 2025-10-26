package ru.aston.homework3.CoR;

import ru.aston.homework3.CoR.handlers.CoffeeMachineHandler;
import ru.aston.homework3.builder.CoffeeType;

import java.util.logging.Logger;

public class CoffeeMachineStub implements CoffeeMachine {
    private final CoffeeMachineHandler firstHandler;
    private final Logger logger;

    public CoffeeMachineStub(CoffeeMachineHandler firstHandler) {
        logger = Logger.getLogger(this.getClass().getName());

        this.firstHandler = firstHandler;
    }

    public void doCoffee(CoffeeType coffeeType) {
        logger.info(
                String.format("Варим %s", coffeeType.getName())
        );
        firstHandler.handler(coffeeType);

        logger.info("Варка завершена");
    }
}
