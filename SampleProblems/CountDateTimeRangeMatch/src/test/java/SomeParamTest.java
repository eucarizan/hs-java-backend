import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "{index} given ranges, when dates compared, then count [{1}]")
    @CsvSource(value = {
            "2017-12-01T00:10; 2017-12-02T00:10; 3; 2017-12-01T00:10; 2017-12-01T13:50; 2017-12-02T00:10 | 2",
            "2017-12-31T23:59; 2017-12-01T00:00; 1; 2017-12-01T00:00 | 1",
            "2017-12-01T00:00; 2017-12-31T23:59; 1; 2017-12-01T00:00 | 1",
            "2017-12-01T00:00; 2017-12-31T23:59; 1; 2017-12-31T23:59 | 0",
            "2017-01-01T00:00; 2017-12-31T23:59; 6; 2017-05-05T00:10; 2017-09-09T01:01; 2017-12-31T23:58; 2018-01-01T00:00; 2016-12-31T23:59; 2018-12-12T00:00 | 3",
            "2018-01-01T00:00; 2017-12-01T23:59; 3; 2018-01-01T00:00; 2017-12-23T11:11; 2017-12-01T23:59 | 2"
    }, delimiter = '|')
    public void test(String input, int expected) {
        String[] parts = input.split("; ");
        LocalDateTime start = LocalDateTime.parse(parts[0]);
        LocalDateTime end = LocalDateTime.parse(parts[1]);
        int n = Integer.parseInt(parts[2]);
        List<LocalDateTime> dates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            LocalDateTime date = LocalDateTime.parse(parts[i + 3]);
            dates.add(date);
        }

        assertEquals(expected, TimeAndDate.compareRange(start, end, dates));
    }
}
