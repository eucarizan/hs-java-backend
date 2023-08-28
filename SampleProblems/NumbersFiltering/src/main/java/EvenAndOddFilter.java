import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EvenAndOddFilter {
    static final int three = 3;
    static final int five = 5;
    static final IntPredicate divisibleBy3And5 = num -> num % three == 0 && num % five == 0;

    private static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
        return IntStream.concat(evenStream, oddStream)
                .sorted()
                .filter(divisibleBy3And5)
                .skip(2);
    }

    public static List<Integer> test(List<Integer> numbers) {
        int[] evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(x -> x)
                .toArray();

        int[] oddNumbers = numbers.stream()
                .filter(n -> n % 2 == 1)
                .mapToInt(x -> x)
                .toArray();

        IntStream filteringStream = EvenAndOddFilter.createFilteringStream(
                Arrays.stream(evenNumbers),
                Arrays.stream(oddNumbers)
        );

        return filteringStream.boxed().collect(Collectors.toList());
    }
}
