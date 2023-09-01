import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "{0}: avgSalary({1}) == {2}")
    @CsvSource(value = {
            "testWithEmptyList : 0 : 0.0",
            "testSingleSalary : 50000 : 50000.0",
            "testMultipleSalary : 50000, 60000, 70000 : 60000.0",
            "testWithNegativeSalaries : 50000, -60000, 70000 : 20000.0",
            "testWithZeroSalary : 50000, 0, 70000 : 40000.0"
    }, delimiter = ':')
    public void testParam(String text, String salaryStr, double expected) {
        List<Integer> salaries;
        String[] salaryParts = salaryStr.split(", ");

        if ("0".equals(salaryParts[0])) {
            salaries = List.of();
        } else {
            salaries = Arrays.stream(salaryParts).map(Integer::parseInt).toList();
        }

        double result = CalculateAveSalary.calcAverageSalary(salaries);

        assertEquals(expected, result, 0.01);
    }
}

/*

    @Test
    public void testCalculateAverageWithMaxIntegerValue() {
        List<Integer> salaries = Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE);

        double actualAverage = AverageSalaryCalculator.calcAverageSalary(salaries);

        assertEquals((double) Integer.MAX_VALUE, actualAverage, 0.001);
    }

    @Test
    public void testCalculateAverageWithMinIntegerValue() {
        List<Integer> salaries = Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE);

        double actualAverage = AverageSalaryCalculator.calcAverageSalary(salaries);

        assertEquals((double) Integer.MIN_VALUE, actualAverage, 0.001);
    }

    @Test
    public void testCalculateAverageWithLargeNegativeInput() {
        List<Integer> salaries = Arrays.asList(-1000000, -2000000, -1500000);

        double actualAverage = AverageSalaryCalculator.calcAverageSalary(salaries);

        assertEquals(-1500000.0, actualAverage, 0.001);
    }

    @Test
    public void testCalculateAverageWithMixedPositiveAndNegative() {
        List<Integer> salaries = Arrays.asList(-10000, 15000, -20000, 25000);

        double actualAverage = AverageSalaryCalculator.calcAverageSalary(salaries);

        assertEquals(2500.0, actualAverage, 0.001);
    }

 */