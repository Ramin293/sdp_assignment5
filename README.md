# SDP Assignment 5: Strategy Pattern

This Java 17 calculator demonstrates the Strategy pattern with interchangeable addition, subtraction, and multiplication algorithms. `Calculator` is the context: it delegates to a `CalculationStrategy` and allows the client to replace that strategy at runtime.

## Pattern roles

| Role | Class | Responsibility |
| --- | --- | --- |
| Strategy | `CalculationStrategy` | Declares `calculate(left, right)` |
| Concrete strategies | `AddStrategy`, `SubtractStrategy`, `MultiplyStrategy` | Implement one arithmetic operation each |
| Context | `Calculator` | Holds the selected strategy and delegates calculation |
| Client | `Main` | Selects strategies and demonstrates runtime switching |

## Build and run

Install JDK 17 or newer and Maven. From this folder, build the project:

```sh
mvn clean package
```

Run the demo:

```sh
java -cp target/classes kz.aitu.assignment5.Main
```

The demo applies all three operations to `12` and `4`. The same `Calculator` instance is reused while the client replaces its strategy.

## Run the checks

Maven compiles the standalone checks during the build. Run them on Windows with:

```powershell
java -cp "target/test-classes;target/classes" kz.aitu.assignment5.StrategyChecks
```

On macOS or Linux, use `:` between classpath entries:

```sh
java -cp "target/test-classes:target/classes" kz.aitu.assignment5.StrategyChecks
```

The checks cover each operation, switching strategies on one calculator, and rejecting a null strategy. A successful run ends with `SUMMARY: 5/5 PASS`.

## Add a strategy

Create a class that implements `CalculationStrategy` and defines its algorithm in `calculate`:

```java
public final class MaximumStrategy implements CalculationStrategy {
    @Override
    public double calculate(double left, double right) {
        return Math.max(left, right);
    }
}
```

Pass an instance to `Calculator` or select it later with `setStrategy`. The context needs no changes when a strategy is added.
