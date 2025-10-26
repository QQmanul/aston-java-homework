package ru.aston.homework3.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CoffeeTypeTest {

    @Test
    void when_buildCoffee_then_returnCorrectObject() {
        String name = "Капучино";
        int espresso = 50;
        int milk = 120;
        int foam = 30;
        int sugar = 5;

        CoffeeType cappuccino = CoffeeType.builder(name, espresso)
                .setMilkAndFoam(milk, foam)
                .setSugarGr(sugar)
                .build();

        assertNotNull(cappuccino);
        assertEquals(name, cappuccino.getName());
        assertEquals(0, cappuccino.getWaterMl());
        assertEquals(milk, cappuccino.getMilkMl());
        assertEquals(foam, cappuccino.getFoamMl());
        assertEquals(sugar, cappuccino.getSugarGr());
    }
}