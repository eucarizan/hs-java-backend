import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} - sumElements({2}) > {3} == {4}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testSumWithValidInput1 : 5 : 5, 8, 11, 2, 10 : 8 : 21",
            "testSumWithValidInput2 : 4 : -5, -4, -6, -11 : -10 : -15",
            "testSumWithNegativeLimit : -2 : 1, 2, 3, 4, 5 : 3 : 0",
            "testSumWithNegativeValue : 5 : 5, 8, 11, 2, 10 : -5 : 36",
            "testSumWithLimitGreaterThanListSize : 10 : 1, 2, 3, 4, 5 : 0 : 15",
            "testSumWithEmptyListAndZeroLimit : 0 : 1, 2, 3, 4, 5 : 2 : 0",
            "testSumWithListSizeGreaterThanLimit : 3 : 1, 2, 3, 4, 5 : 2 : 3",
    }, delimiter = ':')
    public void test(String name, int limit, String input, int value, int expected) {
        List<Integer> param = Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .toList();

        int result = Elements.sum(param, limit, value);

        assertEquals(expected, result);
    }

    @Test
    public void testSumWithEmptyList() {
        // Test with an empty list
        List<Integer> input1 = List.of();
        int input2 = 3;
        int input3 = 5;
        int expectedOutput1 = 0; // The list is empty, so the sum should be 0
        int result1 = Elements.sum(input1, input2, input3);
        assertEquals(expectedOutput1, result1);
    }
}
