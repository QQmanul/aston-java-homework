package ru.aston.homework3.proxy;

import ru.aston.homework3.CoR.CoffeeMachine;
import ru.aston.homework3.CoR.CoffeeMachineStub;
import ru.aston.homework3.CoR.handlers.*;
import ru.aston.homework3.CoR.handlers.*;
import ru.aston.homework3.builder.CoffeeType;

public class CoffeeMachineProxy implements CoffeeMachine {

    private final CoffeeMachine machine;

    public CoffeeMachineProxy() {
        CoffeeMachineHandler espressoHandler = new EspressoHandler();
        CoffeeMachineHandler waterHandler = new WaterHandler();
        CoffeeMachineHandler milkHandler = new MilkHandler();
        CoffeeMachineHandler foamHandler = new FoamHandler();
        CoffeeMachineHandler sugarHandler = new SugarHandler();

        espressoHandler.setNext(waterHandler);
        waterHandler.setNext(sugarHandler);
        sugarHandler.setNext(milkHandler);
        milkHandler.setNext(foamHandler);

        this.machine = new CoffeeMachineStub(espressoHandler);
    }

    @Override
    public void doCoffee(CoffeeType coffeeType) {

        if (coffeeType.getMilkMl() > 0) {
            throw new IllegalStateException("Машина варит только кофе без молока");
        }

        machine.doCoffee(coffeeType);
    }
}
