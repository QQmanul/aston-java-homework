package ru.aston.homework3.strategy;

import ru.aston.homework3.strategy.operations.AdditionIntegerStrategy;
import ru.aston.homework3.strategy.operations.DivisionIntegerStrategy;
import ru.aston.homework3.strategy.operations.MultiplicationIntegerStrategy;
import ru.aston.homework3.strategy.operations.SubtractionIntegerStrategy;

import java.util.logging.Logger;

public class CalculatorDemo {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(CalculatorDemo.class.getName());
        Integer numA = 10, numB = 2;

        Calculator<Integer> calculator = new Calculator<>(
                new AdditionIntegerStrategy()
        );

        logger.info(
                String.format("%d + %d = %d", numA, numB, calculator.calculate(numA, numB))
        );

        calculator.setStrategy(new SubtractionIntegerStrategy());
        logger.info(
                String.format("%d - %d = %d", numA, numB, calculator.calculate(numA, numB))
        );

        calculator.setStrategy(new DivisionIntegerStrategy());
        logger.info(
                String.format("%d / %d = %d", numA, numB, calculator.calculate(numA, numB))
        );

        calculator.setStrategy(new MultiplicationIntegerStrategy());
        logger.info(
                String.format("%d * %d = %d", numA, numB, calculator.calculate(numA, numB))
        );
    }
}
