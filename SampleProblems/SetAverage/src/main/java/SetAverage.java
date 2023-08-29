import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetAverage {

    public static Double avgOnSet(Stream<Integer> numbers) {
        return numbers.collect(Collectors.toSet()).stream()
                .collect(Collectors.averagingInt(Integer::intValue));
    }

    public static Double avgOnSetNJ(Stream<Integer> numbers) {
        Set<Integer> nums = numbers.collect(Collectors.toSet());
        return nums.stream().reduce(0, Integer::sum) * 1.0 / nums.size();
    }
}
