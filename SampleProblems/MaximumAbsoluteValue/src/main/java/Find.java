import java.util.Arrays;

public class Find {
    public static int maxAbsValue(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .map(Math::abs)
                .max().orElse(0);
    }
}
