import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testDayOfMonthWithValidInput : 2017 : 1 : 2017-01-01 2017-01-31",
            "testDayOfMonthWithZeroMonth : 2022 : 0 : 2022-01-01 2022-01-31", // It should default to January
            "testDayOfMonthWithNegativeYear : -2022 : 7 : -2022-07-01 -2022-07-31",
            "testDayOfMonthWithLeapYear : 2020 : 2 : 2020-02-01 2020-02-29",
            "testDayOfMonthWithInvalidMonth : 2022 : 13 : 2022-01-01 2022-01-31", // It should default to January
            "testDayOfMonthWithNegativeMonth : 2022 : -3 : 2022-01-01 2022-01-31", // It should default to January
    }, delimiter = ':')
    public void test(String name, int year, int month, String expected) {
        String result = FirstAndLast.dayOfMonth(year, month);

        assertEquals(expected, result);
    }
}
