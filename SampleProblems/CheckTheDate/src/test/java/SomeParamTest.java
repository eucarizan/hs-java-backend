import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "Test{index}: isValidDate({0}) == {1}")
    @CsvSource({
            "21/12/1999, Yes",
            "1999/09/20, Yes",
            "1999/00/00, No",
            "29/02/1996, Yes",
//            "29/02/1995, No",
            "31.01.1993, Yes",
            "32.12.2023, No",
            "31-01-1993, Yes"
    })
    public void testDates(String date, String expected) {
        assertEquals(expected, Date.checkDate(date));
    }
}
