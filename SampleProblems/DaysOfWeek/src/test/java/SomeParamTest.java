//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.List;
//import java.util.Arrays;
//
//@SuppressWarnings("unused")
//public class SomeParamTest {
//
//    @ParameterizedTest(name = "{0} method({1}) == {2}")
//    @DisplayName("param test")
//    @CsvSource(value = {
//            "test : 1 : [2]",
//    }, delimiter = ':')
//    public void test(String name, String input, int expected) {
//        List<String> param = Arrays.stream(input.split(", ")).toList();
//
//        var result = Enums.daysOfWeek(param);
//
//        assertEquals(expected, result);
//    }
//}
