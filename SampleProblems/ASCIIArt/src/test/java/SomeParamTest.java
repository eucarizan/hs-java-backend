import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "{index} asciiArt({0}) -> {1}")
    @CsvSource({
            "ಠ _ ಠ, (ಠ_ಠ)",
            "• _ •, (•_•)",
            "a b c d, (abcd)",
            "1 2 3, (123)",
            "a, (a)"
    })
    public void test(String input, String expected) {
        List<String> symbols = Arrays.asList(input.split(" "));

        assertEquals(expected, ASCIIArt.asciiArt(symbols));
    }
}
