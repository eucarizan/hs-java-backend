import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "{index} given [{0}], when split to array and get length, then length {1}")
    @CsvSource(value = {
            "Costa Rica, Hungary, Saint Kitts and Nevis, Norway:[5, 4, 7, 5, 5, 3, 5, 6]",
            "Costa Rica, Greece, Malaysia, Peru:[5, 4, 6, 8, 4]"
    }
            , delimiter = ':')
    public void test(String input, String expected) {
        List<String> countries = Arrays.stream(input.split(", "))
                .toList();

        assertEquals(expected, MapCountries.countNumbers(countries).toString());
    }
}
