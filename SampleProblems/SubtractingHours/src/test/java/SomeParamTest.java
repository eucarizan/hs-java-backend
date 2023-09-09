import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
            "testMinusHoursPlusMinutes1 ; 2017-12-15T11:11 ; 1 ; 58 ; 2017-12-15T11:09",
            "testMinusHoursPlusMinutes2 ; 2016-11-22T00:00 ; 5000 ; 300010 ; 2016-11-22T00:10",
            "testMinusHoursPlusMinutesWithNegativeValues ; 2022-09-05T12:00 ; -2 ; -30 ; 2022-09-05T13:30",
            "testMinusHoursPlusMinutesWithInvalidDateTimeFormat ; 2022-09-05 12:00 ; 2 ; 30 ; ''",
            "testMinusHoursPlusMinutesWithNullDateTime ; ; 2 ; 30 ; ''",
            "testMinusHoursPlusMinutesWithEmptyDateTime ; '' ; 2 ; 30 ; ''",
    }, delimiter = ';')
    public void test(String name, String input, int hour, int min, String expected) {
        String result = DateTime.minusHoursPlusMinutes(input, hour, min);

        assertEquals(expected, result);
    }
}
