package ru.aston.homework3.builder;

import java.util.logging.Logger;

public class CoffeeBuilderDemo {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(CoffeeBuilderDemo.class.getName());

        CoffeeType latte = CoffeeType.builder("Латте", 50)
                .setMilkAndFoam(150, 10)
                .setSugarGr(10)
                .build();

        logger.info(latte.toString());

        CoffeeType americanoBlack = CoffeeType.builder("Американо (без сахара)", 50)
                .setWaterMl(150)
                .setSugarGr(0)
                .build();

        logger.info(americanoBlack.toString());
        CoffeeType americanoSweet = CoffeeType.builder("Американо (с сахаром)", 50)
                .setWaterMl(150)
                .setSugarGr(5)
                .build();

        logger.info(americanoSweet.toString());

    }
}
