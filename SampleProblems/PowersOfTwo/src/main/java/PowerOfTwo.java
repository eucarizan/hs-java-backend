import java.util.stream.Stream;

public class PowerOfTwo {

    public static Stream<Integer> generate(int n) {
        return Stream.iterate(1, x -> x << 1).limit(n);
    }

    public static Stream<Integer> generateNJ(int n) {
        return Stream.iterate(0, num -> num + 1).limit(n)
                .map(x -> ((Double) Math.pow(2, x)).intValue());
    }
}
