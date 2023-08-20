import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "Test{index}: isPasswordSafe({0}) == {1}")
    @CsvSource({"Password1234, YES", "SuperSecretPass, NO"})
    public void test(String password, String expected) {
        assertEquals(expected, Password.isSafe(password));
    }
}
