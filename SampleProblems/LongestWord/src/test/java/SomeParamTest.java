import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testLongest : one, two, three, four, five, six : three",
            "testLongestEmptyList : '' : ''",
            "testLongestEqualLengthWords : apple, banana, cherry, date, fig : banana",
            "testLongestSingleWord : apple : apple",
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        List<String> param = Arrays.stream(input.split(", ")).toList();

        String result = Words.longest(param);

        assertEquals(expected, result);
    }
}
