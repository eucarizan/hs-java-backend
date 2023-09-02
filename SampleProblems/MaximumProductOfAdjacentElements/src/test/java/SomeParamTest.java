import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} selectMaxProduct({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testTwoInts : 5, 3 : 15",
            "testThreeInts : 10, 8, 4 : 80",
            "testFiveInts : 4, 11, 12, 11, 11 : 132"
    }, delimiter = ':')
    public void test(String name, String input, long expected) {
        int[] param = Arrays.stream(input.split(", ")).mapToInt(Integer::parseInt).toArray();

        long result = MaxProduct.select(param);

        assertEquals(expected, result);
    }

    @Test
    public void testSelectStreamWithNegativeNumbers() {
        int[] nums = {-5, -3};
        long expectedOutput = 15; // (-5) * (-3) = 15

        long actualOutput = MaxProduct.selectStream(nums);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSelectStreamWithZeroNumbers() {
        int[] nums = {0, 0};
        long expectedOutput = 0; // 0 * 0 = 0

        long actualOutput = MaxProduct.selectStream(nums);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSelectStreamWithEmptyArray() {
        int[] nums = {};
        long expectedOutput = 0; // No pairs to calculate

        long actualOutput = MaxProduct.selectStream(nums);

        assertEquals(expectedOutput, actualOutput);
    }
}
