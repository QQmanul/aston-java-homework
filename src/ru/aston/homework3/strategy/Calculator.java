package ru.aston.homework3.strategy;

import ru.aston.homework3.strategy.operations.CalculationStrategy;

public class Calculator<V> {
    private CalculationStrategy<V> strategy;

    public Calculator(CalculationStrategy<V> strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(CalculationStrategy<V> strategy) {
        this.strategy = strategy;
    }

    public V calculate(V numA, V numB) {
        return this.strategy.calculate(numA, numB);
    }
}
