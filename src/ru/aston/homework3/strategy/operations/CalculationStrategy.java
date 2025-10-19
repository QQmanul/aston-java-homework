package ru.aston.homework3.strategy.operations;

public interface CalculationStrategy<V> {
    public V calculate(V a, V b);
}
