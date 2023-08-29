import java.util.stream.LongStream;

public class QuadraticSum {
    public static long rangeQuadraticSum(int fromIncl, int toExcl) {
        return LongStream
                .range(fromIncl, toExcl)
                .reduce(0, (acc, next) -> acc + next * next);
    }

    public static long rangeQuadraticMapSum(int fromIncl, int toExcl) {
        return LongStream
                .range(fromIncl, toExcl)
                .map(x -> x * x)
                .sum();
    }
}
