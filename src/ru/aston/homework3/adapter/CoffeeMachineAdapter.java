package ru.aston.homework3.adapter;

import ru.aston.homework3.CoR.CoffeeMachineStub;
import ru.aston.homework3.CoR.handlers.CoffeeMachineHandler;
import ru.aston.homework3.builder.CoffeeType;

public class CoffeeMachineAdapter extends CoffeeMachineStub {
    private static final int ESPRESSO_CAP_TO_ML = 30;
    private static final int SUGAR_IN_SPOON = 8;

    public CoffeeMachineAdapter(CoffeeMachineHandler firstHandler) {
        super(firstHandler);
    }

    public void doCoffee(AlienCoffeeType coffeeType) {
        CoffeeType coffee = mapToCoffeeType(coffeeType);

        super.doCoffee(coffee);
    }

    private CoffeeType mapToCoffeeType(AlienCoffeeType coffeeType) {
        return CoffeeType.builder(coffeeType.name(), coffeeType.espressoCap() * ESPRESSO_CAP_TO_ML)
                .setMilkAndFoam(coffeeType.milkMl(), coffeeType.milkMl() * coffeeType.foamPercent() / 100)
                .setSugarGr(coffeeType.sugarSpoons() * SUGAR_IN_SPOON)
                .build();
    }

}
