import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "Test{index} sort({0}) == {1}")
    @CsvSource(value = {
            "apple grape pear banana pineapple:[pineapple, pear, grape, banana, apple]",
            "Cap cape cup cake Cook:[cup, cape, cake, Cook, Cap]"},
            delimiter = ':')
    public void test(String input, String expected) {
        List<String> result = new ArrayList<>(Arrays.asList(input.split(" ")));

        Reverse.sortStrings(result);

        assertEquals(expected, result.toString());
    }
}
