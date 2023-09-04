import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} supplier({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testSample1 : 5 : [0, 1, 2, 3, 4]",
            "testSample2 : 3 : [0, 1, 2]"
    }, delimiter = ':')
    public void test(String name, int input, String expected) {
        List<Integer> result = new ArrayList<>();
        Supplier<Integer> sup = FuncUtils.getInfiniteRangeAtomic();

        for (int i = 0; i < input; i++) {
            result.add(sup.get());
        }

        assertEquals(expected, result.toString());
    }

    @Test
    public void testGetInfiniteRangeWithMultipleSuppliers() {
        Supplier<Integer> sup1 = FuncUtils.getInfiniteRangeAtomic();
        Supplier<Integer> sup2 = FuncUtils.getInfiniteRangeAtomic();

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            output.append(sup1.get()).append(" ").append(sup2.get()).append(" ");
        }

        // Check if the output matches the expected pattern.
        assertEquals("0 0 1 1 2 2 3 3 4 4 ", output.toString());
    }

    @Test
    public void testGetInfiniteRangeWithLargeNumbers() {
        Supplier<Integer> sup = FuncUtils.getInfiniteRange();

        // Test with a large range of numbers.
        for (int i = 0; i < 1_000_000; i++) {
            assertEquals(i, sup.get());
        }
    }

}
