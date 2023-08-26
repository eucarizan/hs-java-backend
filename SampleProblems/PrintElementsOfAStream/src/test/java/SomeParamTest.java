import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "Test{index}: given ({0}), when skip 2 and printed, then ({1})")
    @CsvSource(value = {"1 1 3 5 7 9:[3, 5, 7, 9]", "1 3:[]"}, delimiter = ':')
    public void test(String input, String expected) {
        List<Integer> numbers = Arrays.stream(input.split(" ")).map(Integer::parseInt).toList();

        assertEquals(expected, Utils.printStream(numbers.stream()).toString());
    }
}
