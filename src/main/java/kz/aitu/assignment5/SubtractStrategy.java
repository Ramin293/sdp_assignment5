package kz.aitu.assignment5;

/** Subtracts the right operand from the left operand. */
public final class SubtractStrategy implements CalculationStrategy {
    @Override
    public double calculate(double left, double right) {
        return left - right;
    }
}
