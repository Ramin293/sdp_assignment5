# SDP Assignment 5: Strategy Pattern

This Java 17 project uses a calculator to demonstrate interchangeable arithmetic algorithms. `Calculator` is the context: it delegates each operation to a `CalculationStrategy` and can receive a different strategy at runtime.

## Build

Install JDK 17 and Maven, then run:

```sh
mvn package
```

## Current structure

- `CalculationStrategy` defines the common algorithm contract.
- `Calculator` stores the selected strategy and delegates calculation to it.
- Concrete strategies and the command-line client are the next implementation steps.

## Adding a strategy

Create a class that implements `CalculationStrategy`, define one calculation algorithm in `calculate`, and pass an instance to `Calculator` with its constructor or `setStrategy`. The context does not need to change when a new implementation is added.
