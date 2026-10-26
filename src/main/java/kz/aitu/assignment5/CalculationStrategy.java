package kz.aitu.assignment5;

/** A calculation algorithm that can be selected at runtime. */
public interface CalculationStrategy {
    double calculate(double left, double right);
}
