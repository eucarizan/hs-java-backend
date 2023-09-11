import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} -- isPalindrome({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testEmpty : '' : true",
            "testIsPalindromeWithSingleCharacter : a : true",
            "testIsPalindromeWithOddLengthPalindrome : kayak : true",
            "testIsPalindromeWithEvenLengthPalindrome : deed : true",
            "testIsPalindromeWithMixedCase : Madam : true",
            "testIsPalindromeWithWhitespace : a man a plan a canal panama : true",
            "testIsPalindromeWithNonPalindrome : hello : false",
            "testIsPalindromeWithSpecialCharacters : A man, a plan, a canal, Panama! : true",
    }, delimiter = ':')
    public void test(String name, String param, boolean expected) {
        boolean result = Word.isPalindrome(param);

        assertEquals(expected, result);
    }
}
