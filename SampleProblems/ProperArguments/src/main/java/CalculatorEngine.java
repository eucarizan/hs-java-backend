public class CalculatorEngine {
    public int calculate(int a, int b, String operation) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    yield -1;
                }
                yield a / b;
            }
            default -> 0;
        };
    }
}
