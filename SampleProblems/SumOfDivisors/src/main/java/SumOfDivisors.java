import java.util.stream.IntStream;

public class SumOfDivisors {
    public static int calculate(int a, int b, int n, int m) {
        return IntStream
                .rangeClosed(a, b)
                .filter(num -> num % n == 0 || num % m == 0)
                .reduce(0, Integer::sum);
    }
}
