import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} concatStrings({1}, {2}) == {3}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testBasic : a : b : ab",
            "testOneNull : a : : a",
            "testAllNull : : : ''"
    }, delimiter = ':')
    public void test(String name, String input1, String input2, String expected) {
        String result = NPE.concatStrings(input1, input2);

        assertEquals(expected, result);
    }
}
