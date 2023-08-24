import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamListTest {
    static Stream<Arguments> arguments = Stream.of(
            Arguments.of(new ArrayList<>(List.of(
                    new StockItem("nails", 0.01, 512),
                    new StockItem("hammers", 7.5, 24),
                    new StockItem("screws", 0.02, 318)
            )), List.of(
                    "hammers: 7.5, 24;",
                    "screws: 0.02, 318;",
                    "nails: 0.01, 512;"
            )),
            Arguments.of(new ArrayList<>(List.of(
                    new StockItem("pens", 3.72, 40),
                    new StockItem("pencils", 1.45, 75),
                    new StockItem("notebooks", 0.84, 130)
            )
            ), List.of(
                    "pens: 3.72, 40;",
                    "notebooks: 0.84, 130;",
                    "pencils: 1.45, 75;"
            ))
    );

    @ParameterizedTest(name = "Test {index}:  sort({0}) == {1}")
    @VariableSource("arguments")
    public void test(ArrayList<StockItem> stockItems, List<String> expected) {
        Utils.sort(stockItems);
        List<String> result = new ArrayList<>();
        stockItems.forEach(items -> result.add(items.toString()));

        assertEquals(expected, result);
    }
}