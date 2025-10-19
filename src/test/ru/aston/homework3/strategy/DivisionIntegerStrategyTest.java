package ru.aston.homework3.strategy;

import org.junit.jupiter.api.Test;
import ru.aston.homework3.strategy.operations.CalculationStrategy;
import ru.aston.homework3.strategy.operations.DivisionIntegerStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DivisionIntegerStrategyTest {
    @Test
    void when_getTwoPositiveInteger_then_returnResult() {
        CalculationStrategy<Integer> testStrategy = new DivisionIntegerStrategy();

        Integer numA = 100;
        Integer numB = 20;
        Integer result = 5;

        assertEquals(result, testStrategy.calculate(numA, numB));
    }

    @Test
    void when_getOnePositiveInteger_then_returnResult() {
        CalculationStrategy<Integer>  testStrategy = new DivisionIntegerStrategy();

        Integer numA = 100;
        Integer numB = -20;
        Integer result = -5;

        assertEquals(result, testStrategy.calculate(numA, numB));

        Integer numC = 0;
        result = 0;
        assertEquals(result, testStrategy.calculate(numC, numB));
    }

    @Test
    void when_getTwoNegativeInteger_then_returnResult() {
        CalculationStrategy<Integer>  testStrategy = new DivisionIntegerStrategy();

        Integer numA = -100;
        Integer numB = -20;
        Integer result = 5;

        assertEquals(result, testStrategy.calculate(numA, numB));
    }

    @Test
    void when_divisionByZero_then_throwError() {
        CalculationStrategy<Integer>  testStrategy = new DivisionIntegerStrategy();

        Integer numA = -100;
        Integer numB = 0;

        assertThrows(ArithmeticException.class, () -> testStrategy.calculate(numA, numB));
    }
}