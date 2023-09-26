import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} -- method({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testWith : 1 : [2]",
            "testWith : 3 : [4]",
    }, delimiter = ':')
    public void test(String name, String input param, int expected) {
        List<String> param = Arrays.stream(input.split(", ")).toList();

        var result = Solution.method(param);

        assertEquals(expected, result);
    }
}
