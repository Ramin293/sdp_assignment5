package kz.aitu.assignment5;

/** Multiplies the two operands. */
public final class MultiplyStrategy implements CalculationStrategy {
    @Override
    public double calculate(double left, double right) {
        return left * right;
    }
}
