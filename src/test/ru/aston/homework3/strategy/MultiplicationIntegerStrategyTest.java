package ru.aston.homework3.strategy;

import org.junit.jupiter.api.Test;
import ru.aston.homework3.strategy.operations.CalculationStrategy;
import ru.aston.homework3.strategy.operations.MultiplicationIntegerStrategy;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationIntegerStrategyTest {
    @Test
    void when_getTwoPositiveInteger_then_returnResult() {
        CalculationStrategy<Integer> testStrategy = new MultiplicationIntegerStrategy();

        Integer numA = 100;
        Integer numB = 20;
        Integer result = 2000;

        assertEquals(result, testStrategy.calculate(numA, numB));
    }

    @Test
    void when_getOnePositiveInteger_then_returnResult() {
        CalculationStrategy<Integer>  testStrategy = new MultiplicationIntegerStrategy();

        Integer numA = 100;
        Integer numB = -20;
        Integer result = -2000;

        assertEquals(result, testStrategy.calculate(numA, numB));
    }

    @Test
    void when_getTwoNegativeInteger_then_returnResult() {
        CalculationStrategy<Integer>  testStrategy = new MultiplicationIntegerStrategy();

        Integer numA = -100;
        Integer numB = -20;
        Integer result = 2000;

        assertEquals(result, testStrategy.calculate(numA, numB));
    }

    @Test
    void when_multiplicationByZero_then_returnZero() {
        CalculationStrategy<Integer>  testStrategy = new MultiplicationIntegerStrategy();

        Integer numA = -100;
        Integer numB = 0;
        Integer result = 0;

        assertEquals(result, testStrategy.calculate(numA, numB));
        assertEquals(result, testStrategy.calculate(numB, numA));
    }
}