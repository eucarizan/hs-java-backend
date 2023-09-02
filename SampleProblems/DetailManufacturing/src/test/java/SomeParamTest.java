import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} method({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testSample : Screw, Wrench, Lever : 1. Requested Screw, 2. Requested Wrench, 3. Requested Lever; 3"
    }, delimiter = ':')
    public void test(String name, String input, String expectedStr) {
        List<String> param = Arrays.stream(input.split(", ")).toList();
        List<String> result = new ArrayList<>();
        String[] expectedParts = expectedStr.split("; ");
        List<String> expected = Arrays.stream(expectedParts[0].split(", ")).toList();
        int expectedCount = Integer.parseInt(expectedParts[1]);

        param.forEach(product -> result.add(ManufacturingController.requestProduct(product)));
        int resultCount = ManufacturingController.getNumberOfProducts();

        assertEquals(expected, result);
        assertEquals(expectedCount, resultCount);
    }
}
