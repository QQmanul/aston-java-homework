package ru.aston.homework3.strategy.operations;

public class MultiplicationIntegerStrategy implements CalculationStrategy<Integer> {
    @Override
    public Integer calculate(Integer a, Integer b) {
        return a * b;
    }
}
