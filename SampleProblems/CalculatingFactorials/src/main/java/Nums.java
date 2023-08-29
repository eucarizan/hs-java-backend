import java.util.stream.LongStream;

public class Nums {
    public static long factorial(long n) {
        return LongStream
                .rangeClosed(1, n)
                .reduce(1, (acc, next) -> acc * next);
    }
}
