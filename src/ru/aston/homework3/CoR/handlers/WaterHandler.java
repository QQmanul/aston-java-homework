package ru.aston.homework3.CoR.handlers;

import ru.aston.homework3.builder.CoffeeType;

public class WaterHandler extends BaseCoffeeMachineHandler {

    @Override
    public void handler(CoffeeType coffee) {

        if (coffee.getWaterMl() > 0) {
            this.logger.info(
                    String.format("Нагреваю %d мл воды", coffee.getWaterMl())
            );
        } else {
            this.logger.info("Пропускаю шаг с водой");
        }

        super.handler(coffee);
    }
}
