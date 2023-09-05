import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    //    @ParameterizedTest(name = "{0} method({1}) == {2}")
    @ParameterizedTest
    @DisplayName("param test")
    @CsvSource(value = {
            "sampleTest1 : 2, 8, 11, 14, 19, 20, 22, 25, 28, 30, 46, 48, 51, 53, 54, 55, 56, 59, 64, 75, 77, 78, 84, 87, 93 : 99",
            "sampleTest2 : 8, 9, 17, 25, 27, 30, 32, 34, 37, 38, 40, 46, 48, 52, 53, 55, 56, 59, 62, 65, 69, 73, 83, 84, 85, 89, 90, 91, 98 : 119",
            "sampleTest3 : 1, 6, 8, 10, 11, 16, 26, 29, 30, 33, 36, 39, 43, 44, 46, 47, 48, 53, 55, 57, 58, 74, 77, 82, 83, 84, 89, 96, 98, 99 : 124",
            "sampleTest1 : 1, 9, 11, 23, 27, 28, 29, 32, 37, 44, 46, 48, 49, 53, 56, 59, 60, 61, 65, 69, 70, 73, 78, 79, 80, 82, 84, 85, 90, 95 : 124"
    }, delimiter = ':')
    public void test(String name, String input, int expected) {
        int[] param = Arrays.stream(input.split(", ")).mapToInt(Integer::parseInt).toArray();

        var result = Count.countBinarySearch(param, param);

        assertEquals(expected, result);
    }

    @Test
    void test() {
        int[] param = {8, 9, 17, 25, 27, 30, 32, 34, 37, 38, 40, 46, 48, 52, 53, 55, 56, 59, 62, 65, 69, 73, 83, 84, 85, 89, 90, 91, 98};
        int[] values = {8, 9, 17, 25, 27, 30, 32, 34, 37, 38, 40, 46, 48, 52, 53, 55, 56, 59, 62, 65, 69, 73, 83, 84, 85, 89, 90, 91, 98};

        int result = Count.countBinarySearch(param, values);
        int expected = 119;
        assertEquals(expected, result);
    }
}
