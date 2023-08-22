import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeClassTest {
    @Test
    @DisplayName("whenCountWordsThenSuccess")
    void test1() {
        String[] input = {"a", "b", "b", "c", "d", "a", "b"};

        Map<String, Integer> expected = new TreeMap<>(Map.of(
                "a", 2,
                "b", 3,
                "c", 1,
                "d", 1
        ));

        assertEquals(expected, CountingWords.wordCount(input));
    }

    @Test
    void whenPrintWordThenSuccess() {
        String[] input = {"a", "b", "b", "c", "d", "a", "b"};

        List<String> expected = List.of("a : 2", "b : 3", "c : 1", "d : 1");

        SortedMap<String, Integer> sortedMap = CountingWords.wordCount(input);

        assertEquals(expected, CountingWords.printMap(sortedMap));
    }
}
