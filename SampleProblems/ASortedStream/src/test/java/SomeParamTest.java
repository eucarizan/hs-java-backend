import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "Test{index}: sort({0}) == ({1})")
    @CsvSource(value = {
            "class interface type enum function:[class, enum, function, interface, type]",
            "class:[class]"},
            delimiter = ':'
    )
    public void test(String input, String expected) {
        assertEquals(expected, Utils.sortPrint(Arrays.stream(input.split(" "))).toString());
    }
}
