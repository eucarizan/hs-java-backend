import java.util.List;
import java.util.stream.Collectors;

public class CollectorProduct {
    public static long calculate(List<Integer> numbers) {
//        return numbers.stream()
//                .collect(Collectors.reducing(1, x -> x * x, (x, y) -> x * y));
        return numbers.stream().map(x -> x * x).reduce(1, (x, y) -> x * y);
    }
}
