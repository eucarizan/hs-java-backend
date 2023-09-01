import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} process({1}) == {2}")
    @CsvSource(value = {
            "testSample : 21, 0, 33, 1, 8, 15, 19, 8, 4 : [15, 19, 21, 33]"
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        Collection<Integer> param = input == null ? List.of() : Arrays.stream(input.split(", ")).map(Integer::parseInt).toList();

        List<Integer> result = Numbers.process(param);

        assertEquals(expected, result.toString());
    }

    @Test
    public void testProcessWithEmptyInput() {
        Collection<Integer> numbers = Collections.emptyList();
        List<Integer> expectedOutput = Collections.emptyList();

        List<Integer> actualOutput = Numbers.process(numbers);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testProcessWithNoNumbersGreaterThanTen() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> expectedOutput = Collections.emptyList();

        List<Integer> actualOutput = Numbers.process(numbers);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testProcessWithAllNumbersGreaterThanTen() {
        List<Integer> numbers = Arrays.asList(11, 12, 13, 14, 15);
        List<Integer> expectedOutput = Arrays.asList(11, 12, 13, 14, 15);

        List<Integer> actualOutput = Numbers.process(numbers);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testProcessWithOnlyOneNumberGreaterThanTen() {
        List<Integer> numbers = Arrays.asList(5, 12, 8, 9);
        List<Integer> expectedOutput = List.of(12);

        List<Integer> actualOutput = Numbers.process(numbers);

        assertEquals(expectedOutput, actualOutput);
    }
}
