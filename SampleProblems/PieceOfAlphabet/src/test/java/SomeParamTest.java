import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} -- isAlphabetOrdered({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testIsPieceOfAlphabetWithEmptyString : '' : true",
            "testIsPieceOfAlphabetWithSingleCharacter : a : true",
            "testIsPieceOfAlphabetWithConsecutiveLowerCaseAlphabets : abc : true",
            "testIsPieceOfAlphabetWithConsecutiveUpperCaseAlphabets : XYZ : true",
            "testIsPieceOfAlphabetWithMixedCaseAlphabets : AbCdEfG : true",
            "testIsPieceOfAlphabetWithNonAlphabetCharacters : 123 : false",
            "testIsPieceOfAlphabetWithNonConsecutiveCharacters : bce : false",
            "testIsPieceOfAlphabetWithSpecialCharacters : ab-cd-ef : false",
    }, delimiter = ':')
    public void test(String name, String param, boolean expected) {
        boolean result = CharSequence.isPieceOfAlphabet(param);

        assertEquals(expected, result);
    }
}
