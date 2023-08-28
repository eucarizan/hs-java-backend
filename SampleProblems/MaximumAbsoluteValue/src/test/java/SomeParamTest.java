import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "{index} when maxAbs({0}), then [{1}]")
    @CsvSource(value = {
            "1, 4, 7, -2, -5:7",
            "1, 4, 7, -2, -8:8",
            "1, 2, 3, 4, 5, 6, 7, 8, 9, 0:9",
            "-1, -2, -3, -4, -5, -6, -7, -8, -9:9",
            "-6723, -12363, 2378, 2837, 36712, -123123:123123",
            "999999:999999",
            "-999998:999998"
    }, delimiter = ':')
    public void test(String input, int expected) {
        String[] numbers = input.split(", ");

        assertEquals(expected, Find.maxAbsValue(numbers));
    }
}
