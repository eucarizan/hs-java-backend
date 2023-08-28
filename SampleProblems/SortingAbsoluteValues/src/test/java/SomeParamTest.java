import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "{index} when sortAbs({0}), then {1}")
    @CsvSource(value = {
            "1 2 6 -3 -9:[1, 2, 3, 6, 9]",
            "56 12 9 8 -34 -9 -12:[8, 9, 9, 12, 12, 34, 56]",
            "0 0 0 0 0 0 0 0 0 0:[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
            "-1 -1 -1 -1 -1 -1 -1 -1:[1, 1, 1, 1, 1, 1, 1, 1]",
            "1 1 1 1 1 1 1 1 1:[1, 1, 1, 1, 1, 1, 1, 1, 1]",
            "1 0 -1:[0, 1, 1]",
            "2312 213 812 28 -283 -234 -123 23 3123 123 0 123 -34 -78 -9876:[0, 23, 28, 34, 78, 123, 123, 123, 213, 234, 283, 812, 2312, 3123, 9876]"
    }, delimiter = ':')
    public void test(String input, String expected) {
        String[] output = input.split(" ");

        assertEquals(expected, Arrays.toString(AbsValues.sort(output)));
    }
}
