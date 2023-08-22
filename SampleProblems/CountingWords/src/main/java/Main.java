import java.util.Map;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> expected = Map.of(
                "c", 1,
                "b", 3,
                "d", 1,
                "a", 2
        );

        expected.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("sorted");

        String[] input = {"a", "b", "b", "c", "d", "a", "b"};

        SortedMap<String, Integer> sortedMap = CountingWords.wordCount(input);

        sortedMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}