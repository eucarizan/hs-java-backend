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
            "test1 : 11, 22, 33, 35, 41, 47, 51, 56, 67, 73, 76, 77, 84, 85, 91 " +
                    ": 83, 94, 66, 78, 51, 22, 94, 73, 60, 26, 17, 48, 51, 1, 84 " +
                    ": [84, 91, 67, 77, 51, 22, 91, 73, 56, 22, 22, 47, 51, 11, 84]",
            "test2 : 0, 14, 38, 39, 39, 56, 68, 72, 76, 79, 80, 85, 86, 87, 98 " +
                    ": 96, 58, 76, 24, 98, 25, 28, 36, 48, 12, 33, 1, 33, 98, 51 " +
                    ": [98, 56, 76, 14, 98, 14, 38, 38, 56, 14, 38, 0, 38, 98, 56]",
            "test3 : 0, 2, 13, 14, 20, 39, 41, 55, 74, 78, 90, 92, 92, 96, 98" +
                    ": 7, 81, 35, 82, 29, 5, 32, 20, 37, 73, 34, 33, 74, 7, 78" +
                    ": [2, 78, 39, 78, 20, 2, 39, 20, 39, 74, 39, 39, 74, 2, 78]",
            "test4 : 11, 17, 18, 27, 44, 47, 49, 51, 55, 60, 67, 75, 79, 85, 92 " +
                    ": 26, 28, 85, 77, 57, 22, 89, 50, 30, 56, 68, 87, 71, 18, 67" +
                    ": [27, 27, 85, 75, 55, 18, 92, 49, 27, 55, 67, 85, 67, 18, 67]"
    }, delimiter = ':')
    public void test(String name, String arrayStr, String valuesStr, String expected) {
        int[] array = Arrays.stream(arrayStr.split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] values = Arrays.stream(valuesStr.split(", ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> result = Search.approximateSearch(array, values);

        assertEquals(expected, result.toString());
    }
}
