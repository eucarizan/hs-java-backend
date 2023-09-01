import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} getLongStream({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testGetLongStreamValues1 : 3 : -3, -2, -1, 1, 2, 3",
            "testGetLongStreamValues2 : 1 : -1, 1",
            "testGetLongStreamValues3 : 10 : -10, -9, -8, -7, -6, -5, -4, -3, -2, -1," +
                    " 1, 2, 3, 4, 5, 6, 7, 8, 9, 10"
    }, delimiter = ':')
    public void test(String name, int input, String expectedStr) {
        long[] expected = Arrays.stream(expectedStr.split(",\\s+")).mapToLong(Long::parseLong).toArray();

        LongStream result = StreamOfPrimitives.getLongStream(input);

        assertArrayEquals(expected, result.toArray());
    }

    @Test
    public void testGetLongStreamWithPositiveN() {
        int n = 5;
        LongStream stream = StreamOfPrimitives.getLongStream(n);

        long count = stream.count();

        assertEquals(2 * n, count);
    }

    @Test
    public void testGetLongStreamWithZeroN() {
        int n = 0;
        LongStream stream = StreamOfPrimitives.getLongStream(n);

        long count = stream.count();

        assertEquals(0, count);
    }

    @Test
    public void testGetLongStreamWithNegativeN() {
        int n = -3;
        LongStream stream = StreamOfPrimitives.getLongStream(n);

        long count = stream.count();

        assertEquals(2 * Math.abs(n), count);
    }

//    @Test
//    public void testGetLongStreamWithMaxValue() {
//        int n = Integer.MAX_VALUE;
//        LongStream stream = StreamOfPrimitives.getLongStream(n);
//
//        long count = stream.count();
//
//        assertEquals(2L * n, count);
//    }
//
//    @Test
//    public void testGetLongStreamWithMinValue() {
//        int n = Integer.MIN_VALUE;
//        LongStream stream = StreamOfPrimitives.getLongStream(n);
//
//        long count = stream.count();
//
//        assertEquals(2L * Math.abs((long) n), count);
//    }
}
