import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "Test{index}: {1} == countPasswords({0})")
    @CsvSource(value = {
            "sadfjvDdffg dsajkfj3 fdsv4 sdaffg5:4",
            "asd:1"}
    , delimiter = ':')
    public void test(String input, long expected) {
        List<String> passwordList = Arrays.stream(input.split(" ")).toList();
        long result = Utils.countPasswords(passwordList.stream());

        assertEquals(expected, result);
    }
}
