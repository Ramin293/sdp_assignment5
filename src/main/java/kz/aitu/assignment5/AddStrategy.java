package kz.aitu.assignment5;

/** Adds the two operands. */
public final class AddStrategy implements CalculationStrategy {
    @Override
    public double calculate(double left, double right) {
        return left + right;
    }
}
