import java.util.*;
import java.util.stream.Collectors;

public class CountingWords {
    public static SortedMap<String, Integer> wordCount(String[] array) {

        return Arrays
                .stream(array)
                .collect(Collectors.toMap(
                        k -> k,
                        v -> 1,
                        (v1, v2) -> v1 + 1,
                        TreeMap::new));
    }

    public static List<String> printMap(SortedMap<String, Integer> sortedMap) {
        List<String> list = new ArrayList<>();

        sortedMap.forEach((k, v) -> list.add(k + " : " + v));

        return list;
    }
}
