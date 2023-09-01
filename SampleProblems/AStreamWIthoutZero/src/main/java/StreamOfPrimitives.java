import java.util.function.LongSupplier;
import java.util.stream.LongStream;

public class StreamOfPrimitives {
    public static LongStream getLongStream(int n) {
        long start = n == Integer.MIN_VALUE ? Integer.MIN_VALUE + 1 : -Math.abs(n);
        long end = n == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(n);

        return LongStream.rangeClosed(start, end).filter(num -> num != 0);
    }
}
