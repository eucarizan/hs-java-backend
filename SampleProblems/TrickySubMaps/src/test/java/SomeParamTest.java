import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} getSubMap({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testSample1 : 1 | one, 2 | two, 3 | three, 4 | four, 5 | five, 6 | six, 7 | seven : 5 | five, 4 | four, 3 | three, 2 | two, 1 | one",
            "testSample1 : 2 | two, 4 | four, 6 | six, 8 | eight, 10 | ten, 12 | twelve, 14 | fourteen : 14 | fourteen, 12 | twelve, 10 | ten"
    }, delimiter = ':')
    public void test(String name, String input, String expectedStr) {
        List<String> paramStr = Arrays.stream(input.split(", ")).toList();
        List<String> expectedStrList = Arrays.stream(expectedStr.split(", ")).toList();
        TreeMap<Integer, String> param = new TreeMap<>();
        Map<Integer, String> expected = new TreeMap<>(Collections.reverseOrder());

        paramStr.forEach(str -> {
            String[] parts = str.split(" \\| ");
            param.put(Integer.parseInt(parts[0]), parts[1]);
        });

        expectedStrList.forEach(str -> {
            String[] parts = str.split(" \\| ");
            expected.put(Integer.parseInt(parts[0]), parts[1]);
        });

        Map<Integer, String> result = MapUtils.getSubMap(param);

        assertEquals(expected, result);
    }

    @Test
    public void testGetSubMapWithEmptyMap() {
        TreeMap<Integer, String> map = new TreeMap<>();

        Map<Integer, String> subMap = MapUtils.getSubMap(map);

        assertTrue(subMap.isEmpty());
    }

    @Test
    public void testGetSubMapWithSingleElementMap() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(42, "forty-two");

        Map<Integer, String> subMap = MapUtils.getSubMap(map);

        TreeMap<Integer, String> expectedSubMap = new TreeMap<>();
        expectedSubMap.put(42, "forty-two");

        assertEquals(expectedSubMap, subMap);
    }

    @Test
    public void testGetSubMapWithDescendingEvenFirstKey() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(6, "six");
        map.put(4, "four");
        map.put(2, "two");

        Map<Integer, String> subMap = MapUtils.getSubMap(map);

        TreeMap<Integer, String> expectedSubMap = new TreeMap<>();
        expectedSubMap.put(6, "six");
        expectedSubMap.put(4, "four");
        expectedSubMap.put(2, "two");

        assertEquals(expectedSubMap, subMap);
    }

    @Test
    public void testGetSubMapWithDescendingOddFirstKey() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(5, "five");
        map.put(3, "three");
        map.put(1, "one");

        Map<Integer, String> subMap = MapUtils.getSubMap(map);

        TreeMap<Integer, String> expectedSubMap = new TreeMap<>();
        expectedSubMap.put(5, "five");
        expectedSubMap.put(3, "three");
        expectedSubMap.put(1, "one");

        assertEquals(expectedSubMap, subMap);
    }

    @Test
    @Disabled("negative keys not handled")
    public void testGetSubMapWithNegativeKeys() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(-3, "negative three");
        map.put(-2, "negative two");
        map.put(-1, "negative one");

        Map<Integer, String> subMap = MapUtils.getSubMap(map);

        TreeMap<Integer, String> expectedSubMap = new TreeMap<>();
        expectedSubMap.put(-3, "negative three");
        expectedSubMap.put(-2, "negative two");
        expectedSubMap.put(-1, "negative one");

        assertEquals(expectedSubMap, subMap);
    }

}
