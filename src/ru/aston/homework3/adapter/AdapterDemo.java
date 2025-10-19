package ru.aston.homework3.adapter;

import ru.aston.homework3.CoR.handlers.*;
import org.jetbrains.annotations.NotNull;
import ru.aston.homework3.CoR.handlers.*;

public class AdapterDemo {

    public static void main(String[] args) {
        CoffeeMachineAdapter machine = getMachineStub();

        AlienCoffeeType latte = new AlienCoffeeType("Латте", 2, 150, 10, 2);

        machine.doCoffee(latte);
    }

    private static @NotNull CoffeeMachineAdapter getMachineStub() {
        CoffeeMachineHandler espressoHandler = new EspressoHandler();
        CoffeeMachineHandler waterHandler = new WaterHandler();
        CoffeeMachineHandler milkHandler = new MilkHandler();
        CoffeeMachineHandler foamHandler = new FoamHandler();
        CoffeeMachineHandler sugarHandler = new SugarHandler();

        espressoHandler.setNext(waterHandler);
        waterHandler.setNext(sugarHandler);
        sugarHandler.setNext(milkHandler);
        milkHandler.setNext(foamHandler);

        CoffeeMachineAdapter machine = new CoffeeMachineAdapter(espressoHandler);
        return machine;
    }
}
