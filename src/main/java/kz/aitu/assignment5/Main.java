package kz.aitu.assignment5;

/** Demonstrates selecting and replacing a calculator strategy at runtime. */
public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        double left = 12;
        double right = 4;
        Calculator calculator = new Calculator(new AddStrategy());

        printResult("Addition", left, right, calculator);

        calculator.setStrategy(new SubtractStrategy());
        printResult("Subtraction", left, right, calculator);

        calculator.setStrategy(new MultiplyStrategy());
        printResult("Multiplication", left, right, calculator);
    }

    private static void printResult(String operation, double left, double right, Calculator calculator) {
        System.out.println(operation + ": " + left + " and " + right + " = "
                + calculator.calculate(left, right));
    }
}
