package ru.aston.homework3.decorator;

import ru.aston.homework3.CoR.handlers.BaseCoffeeMachineHandler;
import ru.aston.homework3.CoR.handlers.CoffeeMachineHandler;
import ru.aston.homework3.builder.CoffeeType;

public class CoffeeLevelCheckDecorator extends BaseCoffeeMachineHandler {

    private static double ESPRESSO_ML_TO_COFFEE_GR = 7.0 / 30;
    private int coffeeLevel = 20;

    public CoffeeLevelCheckDecorator(CoffeeMachineHandler handler) {
        super(handler);
    }

    private int mlEspressoToCoffeeGr(int espressoMl) {
        return (int) Math.floor(espressoMl * ESPRESSO_ML_TO_COFFEE_GR);
    }

    @Override
    public void handler(CoffeeType coffee) {

        int requiredCoffee = mlEspressoToCoffeeGr(coffee.getEspressoMl());

        if (requiredCoffee > coffeeLevel) {
            logger.warning("Нехватает кофе!! Добавте кофе: ");
            return;
        }

        coffeeLevel -= requiredCoffee;
        logger.info(
                String.format("Остаток: %d гр.", coffeeLevel)
        );

        super.handler(coffee);
    }
}
