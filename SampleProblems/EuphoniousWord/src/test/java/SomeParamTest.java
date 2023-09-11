import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} createEuphonious({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "test : schedule : 1",
            "test : garage : 0",
            "test : player : 1",
            "test : biiiiig : 2",
    }, delimiter = ':')
    public void test(String name, String input, int expected) {
        int result = Words.createEuphonious(input);

        assertEquals(expected, result);
    }
}
