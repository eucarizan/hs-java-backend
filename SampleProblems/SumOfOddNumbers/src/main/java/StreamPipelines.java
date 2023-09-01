import java.util.List;
import java.util.stream.LongStream;

public class StreamPipelines {
    public static long sumOfOddNumbersInRange(List<Integer> numbers) {
        int min = Math.min(numbers.get(0), numbers.get(1));
        int max = Math.max(numbers.get(0), numbers.get(1));

        return LongStream.rangeClosed(min, max)
                .filter(num -> num % 2 != 0)
                .sum();
    }
}
