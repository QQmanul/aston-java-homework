package ru.aston.homework3.CoR.handlers;

import ru.aston.homework3.builder.CoffeeType;

public class EspressoHandler extends BaseCoffeeMachineHandler {

    @Override
    public void handler(CoffeeType coffee) {
        this.logger.info(
                String.format("Варю эспреесо %d мл", coffee.getEspressoMl())
        );

        super.handler(coffee);
    }
}
