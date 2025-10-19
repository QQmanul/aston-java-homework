package ru.aston.homework3.strategy;

import org.junit.jupiter.api.Test;
import ru.aston.homework3.strategy.operations.AdditionIntegerStrategy;
import ru.aston.homework3.strategy.operations.CalculationStrategy;
import ru.aston.homework3.strategy.operations.DivisionIntegerStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdditionIntegerStrategyTest {

    @Test
    void when_getTwoPositiveInteger_then_returnResult() {
        CalculationStrategy<Integer> testStrategy = new DivisionIntegerStrategy();

        Integer numA = 100;
        Integer numB = 20;
        Integer result = 120;

        assertEquals(result, testStrategy.calculate(numA, numB));
    }

    @Test
    void when_getOnePositiveInteger_then_returnResult() {
        CalculationStrategy<Integer>  testStrategy = new AdditionIntegerStrategy();

        Integer numA = 100;
        Integer numB = -20;
        Integer result = 80;

        assertEquals(result, testStrategy.calculate(numA, numB));
    }

    @Test
    void when_getTwoNegativeInteger_then_returnResult() {
        CalculationStrategy<Integer>  testStrategy = new AdditionIntegerStrategy();

        Integer numA = -100;
        Integer numB = -20;
        Integer result = -120;

        assertEquals(result, testStrategy.calculate(numA, numB));
    }
}