package ru.aston.homework3.decorator;

import ru.aston.homework3.CoR.handlers.*;
import org.jetbrains.annotations.NotNull;
import ru.aston.homework3.CoR.CoffeeMachineStub;
import ru.aston.homework3.CoR.handlers.*;
import ru.aston.homework3.builder.CoffeeType;

public class DecoratorDemo {

    public static void main(String[] args) {
        CoffeeMachineStub machine = getMachineStub();

        CoffeeType latte = CoffeeType.builder("Латте", 50)
                .setMilkAndFoam(150, 10)
                .setSugarGr(10)
                .build();

        CoffeeType americanoBlack = CoffeeType.builder("Американо (без сахара)", 50)
                .setWaterMl(150)
                .setSugarGr(0)
                .build();


        machine.doCoffee(latte);
        machine.doCoffee(americanoBlack);
    }

    private static @NotNull CoffeeMachineStub getMachineStub() {
        CoffeeMachineHandler espressoHandler = new EspressoHandler();
        CoffeeMachineHandler coffeeDecorator = new CoffeeLevelCheckDecorator(espressoHandler);
        CoffeeMachineHandler waterHandler = new WaterHandler();
        CoffeeMachineHandler milkHandler = new MilkHandler();
        CoffeeMachineHandler foamHandler = new FoamHandler();
        CoffeeMachineHandler sugarHandler = new SugarHandler();

        coffeeDecorator.setNext(waterHandler);
        waterHandler.setNext(sugarHandler);
        sugarHandler.setNext(milkHandler);
        milkHandler.setNext(foamHandler);

        CoffeeMachineStub machine = new CoffeeMachineStub(coffeeDecorator);
        return machine;
    }
}
