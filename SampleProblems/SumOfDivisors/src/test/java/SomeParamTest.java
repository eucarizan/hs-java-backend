import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "{index} when sumOfDivisors({0}), then [{1}]")
    @CsvSource(value = {
            "10, 20, 2, 3 : 105",
            "1, 100, 1, 1 : 5050",
            "200, 2000, 5, 7 : 622213",
            "1, 10000, 13, 21 : 6051073",
            "455, 5981, 55, 91 : 511030"
    }, delimiter = ':')
    public void test(String input, int expected) {
        int[] parts = Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        assertEquals(expected, SumOfDivisors.calculate(parts[0], parts[1], parts[2], parts[3]));
    }
}
