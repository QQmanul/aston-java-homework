package ru.aston.homework3.CoR.handlers;

import ru.aston.homework3.builder.CoffeeType;

public class FoamHandler extends BaseCoffeeMachineHandler {
    @Override
    public void handler(CoffeeType coffee) {
        if (coffee.getFoamMl() > 0) {
            this.logger.info(
                    String.format("Вспениваю %d мл молока", coffee.getFoamMl())
            );
        } else {
            this.logger.info("Пропускаю шаг с молочной пенкой");
        }

        super.handler(coffee);
    }
}
