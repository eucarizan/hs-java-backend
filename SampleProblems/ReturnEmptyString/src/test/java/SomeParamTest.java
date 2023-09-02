import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} method({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testSample : a string : A STRING",
            "testNull : : "
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        String result = NPE.toUpperCase(input);

        assertEquals(Optional.ofNullable(expected).orElse(""), result);
    }

    @Test
    public void testToUpperCaseWithEmptyString() {
        String input = "";
        String expectedOutput = "";

        String actualOutput = NPE.toUpperCase(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToUpperCaseWithMixedCaseString() {
        String input = "MiXeD CaSe";
        String expectedOutput = "MIXED CASE";

        String actualOutput = NPE.toUpperCase(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToUpperCaseWithSpecialCharacters() {
        String input = "Special!@#$%^&*()Characters";
        String expectedOutput = "SPECIAL!@#$%^&*()CHARACTERS";

        String actualOutput = NPE.toUpperCase(input);

        assertEquals(expectedOutput, actualOutput);
    }

}
