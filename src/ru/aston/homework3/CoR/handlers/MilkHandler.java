package ru.aston.homework3.CoR.handlers;

import ru.aston.homework3.builder.CoffeeType;

public class MilkHandler extends BaseCoffeeMachineHandler {

    @Override
    public void handler(CoffeeType coffee) {
        if (coffee.getMilkMl() <= 0) {
            this.logger.info("Пропускаю шаг с молоком");
        } else {
            this.logger.info(
                    String.format("Нагреваю %d мл молока", coffee.getMilkMl())
            );
        }

        super.handler(coffee);
    }
}
