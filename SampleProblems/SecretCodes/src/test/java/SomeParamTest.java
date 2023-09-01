import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} extract({1}) -> {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "test1 : #88D4, #0000, #ACCD, #444C, #FFFF, #5E62 : [#ACCD, #444C]",
            "test2 : #0000, #AAAA, #FFFF : [#AAAA]"
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        List<String> codes = Arrays.stream(input.split(", ")).toList();

        String result = Codes.extract(codes).toString();

        assertEquals(expected, result);
    }

    @Test
    public void testExtractWithEmptyInput() {
        List<String> codes = Collections.emptyList();
        List<String> expectedOutput = Collections.emptyList();

        List<String> actualOutput = Codes.extract(codes);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testExtractWithNoStartMarker() {
        List<String> codes = Arrays.asList("#1234", "#ABCD", "#FFFF");
        List<String> expectedOutput = Collections.emptyList();

        List<String> actualOutput = Codes.extract(codes);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testExtractWithNoEndMarker() {
        List<String> codes = Arrays.asList("#0000", "#AAAA", "#1234");
        List<String> expectedOutput = Arrays.asList("#AAAA", "#1234");

        List<String> actualOutput = Codes.extract(codes);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testExtractWithStartAndEndMarkerOnly() {
        List<String> codes = Arrays.asList("#0000", "#FFFF");
        List<String> expectedOutput = Collections.emptyList();

        List<String> actualOutput = Codes.extract(codes);

        assertEquals(expectedOutput, actualOutput);
    }
}
