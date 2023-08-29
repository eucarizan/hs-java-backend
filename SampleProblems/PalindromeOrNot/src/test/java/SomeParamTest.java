import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "{index} isPalindrome({0}) == {1}")
    @CsvSource(value = {
            "aaaa, aaa, a, aa : {false=[], true=[aaaa, aaa, a, aa]}",
            "level, bbaa, ac : {false=[bbaa, ac], true=[level]}"
    }, delimiter = ':')
    public void test(String input, String expected) {
        String[] words = input.split(", ");
        assertEquals(expected, CollectorPalindrome.isPalindrome(words).toString());
    }
}
