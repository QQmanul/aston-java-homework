package ru.aston.homework3.CoR.handlers;

import ru.aston.homework3.builder.CoffeeType;

public class SugarHandler extends BaseCoffeeMachineHandler {
    @Override
    public void handler(CoffeeType coffee) {
        if (coffee.getSugarGr() > 0) {
            this.logger.info(
                    String.format("Насыпаю %d грамм сахара", coffee.getSugarGr())
            );
        } else {
            this.logger.info("Пропускаю шаг с сахором");
        }

        super.handler(coffee);
    }
}
