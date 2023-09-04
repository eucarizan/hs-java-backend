import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} top10(input) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testSample1 : Functions bring happiness! : [bring, functions, happiness]",
            "testSample2 : Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim. : [consectetur, faucibus, ipsum, lorem, adipiscing, amet, dolor, eget, elit, mi]"
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        List<String> result = FunctionUtils.topTen(input);

        assertEquals(expected, result.toString());
    }

    @Test
    public void testTopTenWithEmptyInput() {
        String input = "";
        List<String> result = FunctionUtils.topTen(input);

        // For an empty input, the result should be an empty list.
        assertTrue(result.isEmpty());
    }

    @Test
    public void testTopTenWithShortInput() {
        String input = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
        List<String> result = FunctionUtils.topTen(input);

        // The input contains all lowercase letters, and the result should be the first ten letters in alphabetical order.
        List<String> expected = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");

        assertEquals(expected, result);
    }

    @Test
    public void testTopTenWithDuplicateWords() {
        String input = "apple apple banana banana cherry cherry date date";
        List<String> result = FunctionUtils.topTen(input);

        List<String> expected = List.of("apple", "banana", "cherry", "date");

        assertEquals(expected, result);
    }

    @Test
    public void testTopTenWithLongInput() {
        // A long input string with repeating words.
        String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. "
                + "Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. "
                + "Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. "
                + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";

        List<String> result = FunctionUtils.topTen(input);

        List<String> expected = List.of("consectetur", "faucibus", "ipsum", "lorem", "adipiscing", "amet", "dolor", "eget", "elit", "mi");

        assertEquals(expected, result);
    }

    @Test
    public void testTopTenWithMixedCaseInput() {
        // Input with mixed case words.
        String input = "The quick Brown Fox jumped over the Lazy Dog.";

        List<String> result = FunctionUtils.topTen(input);

        List<String> expected = List.of("the", "brown", "dog", "fox", "jumped", "lazy", "over", "quick");

        assertEquals(expected, result);
    }

    @Test
    public void testTopTenWithNumbersAndSymbols() {
        // Input with numbers and symbols.
        String input = "apple 1234 banana @#%^ cherry 5678 date $%^&*";

        List<String> result = FunctionUtils.topTen(input);

        List<String> expected = List.of("apple", "banana", "cherry", "date");

        assertEquals(expected, result);
    }
}
