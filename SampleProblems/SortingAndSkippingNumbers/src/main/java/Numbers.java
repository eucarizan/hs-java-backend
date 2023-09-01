import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    public static List<Integer> process(Collection<Integer> numbers) {
        if (numbers.isEmpty()) {
            return List.of();
        }

        return numbers.stream()
                .sorted()
                .dropWhile(num -> num < 10)
                .collect(Collectors.toList());
    }
}
