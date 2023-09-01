import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} sumOfOddNumbersInRange({1}) == {2}")
    @CsvSource(value = {
            "testSample1 : 0, 0 : 0",
            "testSample2 : 7, 9 : 16",
            "testSample3 : 21, 30 : 125"
    }, delimiter = ':')
    public void test(String name, String input, long expected) {
        List<Integer> param = Arrays.stream(input.split(", ")).map(Integer::parseInt).toList();

        long result = StreamPipelines.sumOfOddNumbersInRange(param);

        assertEquals(expected, result);
    }

    @Test
    public void testSumOfOddNumbersInRangeWithNegativeRange() {
        List<Integer> numbers = Arrays.asList(-5, 2);
        long expectedSum = -8;

        long actualSum = StreamPipelines.sumOfOddNumbersInRange(numbers);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testSumOfOddNumbersInRangeWithNegativeStartAndEnd() {
        List<Integer> numbers = Arrays.asList(-5, -2);
        long expectedSum = -8;

        long actualSum = StreamPipelines.sumOfOddNumbersInRange(numbers);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testSumOfOddNumbersInRangeWithNegativeStartAndPositiveEnd() {
        List<Integer> numbers = Arrays.asList(-5, 5);
        long expectedSum = 0;

        long actualSum = StreamPipelines.sumOfOddNumbersInRange(numbers);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testSumOfOddNumbersInRangeWithPositiveStartAndNegativeEnd() {
        List<Integer> numbers = Arrays.asList(5, -5);
        long expectedSum = 0;

        long actualSum = StreamPipelines.sumOfOddNumbersInRange(numbers);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testSumOfOddNumbersInRangeWithSameStartAndEnd() {
        List<Integer> numbers = Arrays.asList(7, 7);
        long expectedSum = 7;

        long actualSum = StreamPipelines.sumOfOddNumbersInRange(numbers);

        assertEquals(expectedSum, actualSum);
    }
}
