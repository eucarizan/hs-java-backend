import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "{index} given [{0}], when string length < 4, then {1}")
    @CsvSource(value = {
            "its no long string:[its, no]",
            "a bb cc bb a dddd eeeee:[a, bb, cc, bb, a]",
            "coffe redbull tea coffe redbull code:[tea]",
            "show me your code and I'll tell you who you are:[me, and, you, who, you, are]"
    }, delimiter = ':')
    public void test(String input, String expected) {
        List<String> inputList = generateList(input);

        assertEquals(expected, StringStream.omitLongStrings(inputList).toList().toString());
    }

    private List<String> generateList(String text) {
        return new ArrayList<>(Arrays.asList(text.split(" ")));
    }
}
