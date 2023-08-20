import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "Test{index}: isValidIP({0}) == {1}")
    @CsvSource({
            "127.0.0.1, YES",
            "256.0.0.1, NO",
            "127.0.1, NO",
            "192.168.123.231, YES",
            "-1.0.0.1, NO",
            "127.0.0.1., NO",
            "127.0.249.1, YES",
            "255.255.255.255, YES"
    })
    public void test(String address, String expected) {
        assertEquals(expected, IPAddress.check(address));
    }
}
