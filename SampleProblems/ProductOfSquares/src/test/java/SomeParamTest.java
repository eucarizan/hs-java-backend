import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "{index} productSquares({0}) == {1}")
    @CsvSource(value = {
            "0, 1, 2, 3 : 0",
            "1, 2 : 4",
            "1, 2, 3, 4, 5, 6, 7, 8 : 1625702400",
            "1, 50, 10 : 250000",
            "50, 51 : 6502500",
            "100, 0, 100 : 0",
            "1 : 1",
            "0 : 0",
            "1000 : 1000000",
            "1000, 2 : 4000000"
    }, delimiter = ':')
    public void test(String input, long expected) {
        List<Integer> numbers = Arrays.stream(input.split(", ")).map(Integer::parseInt).toList();
        assertEquals(expected, CollectorProduct.calculate(numbers));
    }
}
