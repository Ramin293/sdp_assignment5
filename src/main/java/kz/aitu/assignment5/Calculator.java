package kz.aitu.assignment5;

import java.util.Objects;

/** Delegates a calculation to the currently selected strategy. */
public final class Calculator {
    private CalculationStrategy strategy;

    public Calculator(CalculationStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(CalculationStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "strategy must not be null");
    }

    public double calculate(double left, double right) {
        return strategy.calculate(left, right);
    }
}
