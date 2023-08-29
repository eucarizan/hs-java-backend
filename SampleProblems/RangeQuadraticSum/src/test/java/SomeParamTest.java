import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "Test{index} when rangeQuadraticSum({0}), then [{1}]")
    @CsvSource(value = {
            "10, 12: 221",
            "5, 6: 25",
            "3, 3: 0"
    }, delimiter = ':')
    public void test(String input, long expected) {
        int[] parts = Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        assertEquals(expected, QuadraticSum.rangeQuadraticSum(parts[0], parts[1]));
    }

    @ParameterizedTest(name = "Test{index} when rangeQuadraticMapSum({0}), then [{1}]")
    @CsvSource(value = {
            "10, 12: 221",
            "5, 6: 25",
            "3, 3: 0"
    }, delimiter = ':')
    public void test2(String input, long expected) {
        int[] parts = Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        assertEquals(expected, QuadraticSum.rangeQuadraticMapSum(parts[0], parts[1]));
    }
}
