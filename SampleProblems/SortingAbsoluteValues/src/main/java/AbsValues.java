import java.util.Arrays;

public class AbsValues {
    public static int[] sort(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .map(Math::abs)
                .sorted()
                .toArray();
    }
}
