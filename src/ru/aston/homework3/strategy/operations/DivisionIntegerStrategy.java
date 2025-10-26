package ru.aston.homework3.strategy.operations;

public class DivisionIntegerStrategy implements CalculationStrategy<Integer> {

    @Override
    public Integer calculate(Integer a, Integer b) {
        return a / b;
    }
}
