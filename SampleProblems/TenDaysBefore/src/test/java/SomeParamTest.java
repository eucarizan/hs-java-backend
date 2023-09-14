import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} -- dateMinus10Days({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testEmptyInput : '' : -999999999-01-01",
            "testNormalDate : 2017-06-03 : 2017-05-24",
            "testAnotherNormalDate : 2017-04-28 : 2017-04-18",
            "testFebNotLeapYear : 2021-03-10 : 2021-02-28",
            "testFebLeapYear : 2020-03-10 : 2020-02-29",
            "testPreviousYear : 2021-01-10 : 2020-12-31",
    }, delimiter = ':')
    public void test(String name, String param, String expected) {
        String result = DateBefore.changeDate(param).toString();

        assertEquals(expected, result);
    }
}
