 import org.example.FindNearest;
 import org.junit.jupiter.params.ParameterizedTest;
 import org.junit.jupiter.params.provider.Arguments;

 import java.util.ArrayList;
 import java.util.List;
 import java.util.stream.Stream;

 import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {
    static Stream<Arguments> arguments = Stream.of(
            Arguments.of(new ArrayList<>(List.of(1, 2, 4, 5)), 3, new ArrayList<>(List.of(2, 4))),
            Arguments.of(new ArrayList<>(List.of(1, 2, 3, 4)), 6, new ArrayList<>(List.of(4))),
            Arguments.of(new ArrayList<>(List.of(5, 1, 3, 3, 1, 5)), 4, new ArrayList<>(List.of(3, 3, 5, 5)))
    );

     @ParameterizedTest(name = "Test {index}:  findNearest({1}, {0}) == {2}")
     @VariableSource("arguments")
    // param - int input, int expected
    public void test(ArrayList<Integer> nums, int target, ArrayList<Integer> expected) {
         assertEquals(expected, FindNearest.find(target, nums));
    }
}