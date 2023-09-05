import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0}, when checkIfIsNumber({1}), then {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "givenPositiveInteger : 123 : YES",
            "givenIntegerWithLeadingZeroes : 0123 : NO",
            "givenValidNegativeInteger : -56.0 : YES",
            "givenValidNegativeDecimalWithZeroFractionalPart : -0,05 : YES",
            "givenDecimalWithTrailingZeros : -23.230 : NO",
            "givenVeryLargePositiveDecimal : +12376352189432535347623423443417,36817231873134176345178234234234234 : YES",
            "givenDecimalWithZeroValuesBeforeAndAfterComma : 0,0 : YES",
            "givenNumberWithConsecutivePlusSigns : ++7832468764 : NO",
            "givenNumberWithBothPlusAndMinusSigns : -+72342784628 : NO",
            "givenVeryLargeNegativeInteger : -2347164364537834578354786345786345781484375289746525467124812746 : YES",
            "givenIntegerWithLeadingZeros : -0123 : NO",
            "givenValidDecimalWithTrailingZeros : 990,000000001 : YES",
            "givenValidDecimalWithNon-ZeroFractionalPart : 1,000000001 : YES",
            "givenValidDecimalWithNon-ZeroFractionalPart : 1.10000001 : YES",
            "givenValidDecimalWithTrailingZeros : 0,000000001 : YES",
            "givenValidDecimalWithZeroFractionalPart : 1.0 : YES",
            "givenValidNegativeDecimalWithNon-ZeroFractionalPart : -1237,000000001  : YES",
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        String result = NumberRegex.isNumber(input);

        assertEquals(expected, result);
    }

    @Test
    public void testIsNumberWithEdgeCases() {
        // Edge case: Empty string should not be a number.
        assertEquals("NO", NumberRegex.isNumber(""));

        // Edge case: A single digit should be considered a number.
        assertEquals("YES", NumberRegex.isNumber("5"));

        // Edge case: Leading and trailing whitespace should not affect number detection.
        assertEquals("YES", NumberRegex.isNumber("  123  "));

        // Edge case: A single digit with a leading zero should not be a number.
        assertEquals("NO", NumberRegex.isNumber("01"));

        // Edge case: A valid integer with a trailing dot should not be a number.
        assertEquals("NO", NumberRegex.isNumber("123."));

        // Edge case: A valid integer with a trailing comma should not be a number.
        assertEquals("NO", NumberRegex.isNumber("123,"));

        // Edge case: A valid decimal number with multiple decimal points is not a number.
        assertEquals("NO", NumberRegex.isNumber("12.34.56"));

        // Edge case: A valid number with an empty decimal part.
        assertEquals("NO", NumberRegex.isNumber("123."));

        // Edge case: A valid number with a single digit after the decimal point.
        assertEquals("YES", NumberRegex.isNumber("123.5"));

        // Edge case: A valid number with a comma as the decimal separator.
        assertEquals("YES", NumberRegex.isNumber("123,5"));
    }
}
