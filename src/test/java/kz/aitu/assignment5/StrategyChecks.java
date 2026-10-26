package kz.aitu.assignment5;

/** Standalone checks for calculator operations and runtime strategy replacement. */
public final class StrategyChecks {
    private static int passed;
    private static int total;

    private StrategyChecks() {
    }

    public static void main(String[] args) {
        check("T1", "Addition", new AddStrategy().calculate(12, 4), 16);
        check("T2", "Subtraction", new SubtractStrategy().calculate(12, 4), 8);
        check("T3", "Multiplication", new MultiplyStrategy().calculate(12, 4), 48);
        checkRuntimeSwitching();
        checkNullStrategyRejection();

        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
        if (passed != total) {
            throw new AssertionError("Strategy checks failed");
        }
    }

    private static void checkRuntimeSwitching() {
        Calculator calculator = new Calculator(new AddStrategy());
        double sum = calculator.calculate(12, 4);
        calculator.setStrategy(new SubtractStrategy());
        double difference = calculator.calculate(12, 4);
        calculator.setStrategy(new MultiplyStrategy());
        double product = calculator.calculate(12, 4);

        boolean success = sum == 16 && difference == 8 && product == 48;
        report("T4", "One calculator switches among all strategies", success);
    }

    private static void checkNullStrategyRejection() {
        Calculator calculator = new Calculator(new AddStrategy());
        boolean rejected = false;
        try {
            calculator.setStrategy(null);
        } catch (NullPointerException exception) {
            rejected = true;
        }
        boolean success = rejected && calculator.calculate(12, 4) == 16;
        report("T5", "Null strategy is rejected without losing current strategy", success);
    }

    private static void check(String id, String description, double actual, double expected) {
        boolean success = Double.compare(actual, expected) == 0;
        report(id, description, success);
        if (!success) {
            System.out.println("   expected: " + expected);
            System.out.println("   actual:   " + actual);
        }
    }

    private static void report(String id, String description, boolean success) {
        total++;
        if (success) {
            passed++;
        }
        System.out.println(id + " " + (success ? "PASS" : "FAIL") + " | " + description);
    }
}
