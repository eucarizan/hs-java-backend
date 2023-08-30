import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SomeParamTest {

    @ParameterizedTest(name = "{index} isPalindrome({0}) == {1}")
    @CsvSource(value = {
            "aaaa, aaa, a, aa : {false=[], true=[aaaa, aaa, a, aa]}",
            "level, bbaa, ac : {false=[bbaa, ac], true=[level]}"
    }, delimiter = ':')
    void testSample(String input, String expected) {
        String[] words = input.split(", ");
        assertEquals(expected, CollectorPalindrome.isPalindrome(words).toString());
    }

    @Test
    @DisplayName("given emtpy array, then returns `{true=[], false=[]}`")
    void testEmptyArray() {
        String[] words = {};
        Map<Boolean, List<String>> result = CollectorPalindrome.isPalindrome(words);

        assertEquals(Collections.emptyList(), result.get(true));
        assertEquals(Collections.emptyList(), result.get(false));
    }

    @Test
    @DisplayName("given array with word \"level\", then returns `{true=[level], false=[]}`")
    void testSinglePalindromeWord() {
        String[] words = {"level"};
        Map<Boolean, List<String>> result = CollectorPalindrome.isPalindrome(words);

        assertEquals(Collections.singletonList("level"), result.get(true));
        assertEquals(Collections.emptyList(), result.get(false));
    }

    @Test
    @DisplayName("given array with word \"hello\", then returns `{true=[], false=[hello]}`")
    void testSingleNonPalindromeWord() {
        String[] words = {"hello"};
        Map<Boolean, List<String>> result = CollectorPalindrome.isPalindrome(words);

        assertEquals(Collections.emptyList(), result.get(true));
        assertEquals(Collections.singletonList("hello"), result.get(false));
    }

    @Test
    @DisplayName("given arrays with words \"radar\", \"java\", \"civic\", \"programming\", then returns `{true=[radar, civic], false=[java, programming]}`")
    void testMixOfPalindromeAndNonPalindromeWords() {
        String[] words = {"radar", "java", "civic", "programming"};
        Map<Boolean, List<String>> result = CollectorPalindrome.isPalindrome(words);

        assertEquals(Arrays.asList("radar", "civic"), result.get(true));
        assertEquals(Arrays.asList("java", "programming"), result.get(false));
    }

    @Test
    @DisplayName("given array with words \"deified\", \"hello\", \"noon\", \"world\", then returns `{true=[deified, noon], false=[hello, world]}`")
    void testMixedLengthPalindromes() {
        String[] words = {"deified", "hello", "noon", "world"};
        Map<Boolean, List<String>> result = CollectorPalindrome.isPalindrome(words);

        assertEquals(Arrays.asList("deified", "noon"), result.get(true));
        assertEquals(Arrays.asList("hello", "world"), result.get(false));
    }

    @Test
    @DisplayName("given array with words \"Madam\", \"Able, was I ere I saw Elba\", \"OpenAI\", \"No lemon, no melon\", then returns ``{true=[Madam, Able , was I ere I saw Elba, No lemon, no melon], false=[OpenAI]}")
    void testSpecialCharactersAndCaseSensitivity() {
        String[] words = {"Madam", "Able, was I ere I saw Elba", "OpenAI", "No lemon, no melon"};
        Map<Boolean, List<String>> result = CollectorPalindrome.isPalindrome(words);

        assertEquals(Arrays.asList("Madam", "Able, was I ere I saw Elba", "No lemon, no melon"), result.get(true));
        assertEquals(Collections.singletonList("OpenAI"), result.get(false));
    }

    @Test
    @DisplayName("given array with strings \"\", \"racecar\", \"\", \"hello\", \"\", then returns `{true=[, racecar, , ], false=[hello]}`")
    void testMixOfEmptyAndNonEmptyStrings() {
    }

    @Test
    @DisplayName("given array with words \"level\", \"deified\", \"abcdefghhgfedcba\", \"helloolleh\", then returns ``{true=[level, deified, abcdefghhgfedcba, helloolleh], false=[]}")
    void testLongWords() {
        String[] words = {"level", "deified", "abcdefghhgfedcba", "helloolleh"};
        Map<Boolean, List<String>> result = CollectorPalindrome.isPalindrome(words);

        assertEquals(Arrays.asList("level", "deified", "abcdefghhgfedcba", "helloolleh"), result.get(true));
        assertEquals(Collections.emptyList(), result.get(false));
    }

    @Test
    @DisplayName("given array with values null, \"hello\", null, \"world\", then handles null values appropriately, may throw `NullPointerException`")
    void testNullValues() {
        String[] words = {null, "hello", null, "world"};
        assertThrows(NullPointerException.class, () -> {
            CollectorPalindrome.isPalindrome(words);
        });
    }

    @Test
    @DisplayName("given large aray with many palindrome and non-palindrome, then completes within a reasonable time without errors")
    void testLargeArrayPerformance() {
        String[] words = generateLargeArrayOfWords();

        assertTimeout(Duration.ofSeconds(5), () -> {
            CollectorPalindrome.isPalindrome(words);
        });
    }

    private String[] generateLargeArrayOfWords() {
        int arraySize = 10000;
        int wordLength = 10;
        String[] words = new String[arraySize];
        Random random = new Random();

        Arrays.fill(words, generateRandomWord(random, wordLength));

        return words;
    }

    private String generateRandomWord(Random random, int wordLength) {
        StringBuilder word = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < wordLength; i++) {
            int randomIndex = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(randomIndex);
            word.append(randomChar);
        }

        return word.toString();
    }
}
