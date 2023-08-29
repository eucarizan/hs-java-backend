import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "{index} avgOnSet({0}) == {1}")
    @CsvSource(value = {
            "1, 3, 1, 3, 1 : 2.0",
            "1, 2, 3, 4, 2 : 2.5",
            "0, 0, 0 : 0.0",
            "1, 1, 1, 1 : 1.0"
    }, delimiter = ':')
    public void test(String input, double expected) {
        Stream<Integer> stream = Arrays.stream(input.split(", ")).map(Integer::parseInt);
        assertEquals(expected, SetAverage.avgOnSet(stream));
    }
}
