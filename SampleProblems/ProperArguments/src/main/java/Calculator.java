public class Calculator {
    private final CalculatorEngine engine;

    public Calculator(CalculatorEngine engine) {
        this.engine = engine;
    }

    public int sum(int a, int b) {
        return engine.calculate(a, b, "+");
    }
}
