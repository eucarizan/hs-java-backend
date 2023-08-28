import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "{index} given [{0}], when count distinct case insensitive, then [{1}]")
    @CsvSource(value = {
            "3; Word word wOrd, line Line SplinE word, spline align Java java:5",
            "2; a A a A, B b B b:2",
            "1; one One oNe onE ONe OnE oNE ONE:1",
            "4; word1 word2 word3 word4, word5, word6 word7 word8 word9, word10:10"
    }, delimiter = ':')
    public void test(String input, int expected) {
        String[] parts = input.split("; ");
        int n = Integer.parseInt(parts[0]);
        String[] linesArray = parts[1].split(", ");

        List<List<String>> lines = Arrays.stream(linesArray)
                .map(s -> Arrays.asList(s.split(" ")))
                .toList();

        assertEquals(expected, Words.countWithoutRepetitions(n, lines));
    }
}
