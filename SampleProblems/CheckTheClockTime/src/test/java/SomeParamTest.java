import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "Test{index}: clockTimeValid({0}) == {1}")
    @CsvSource({"09:00, YES", "23:59, YES", "24:00, NO", "10:1, NO", "20:18, YES"})
    public void test(String time, String expected) {
        assertEquals(expected, Clock.checkTime(time));
    }
}
