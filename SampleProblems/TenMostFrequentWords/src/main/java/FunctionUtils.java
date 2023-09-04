import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionUtils {

    public static List<String> topTen(String text) {
        if ("".equals(text)) {
            return List.of();
        }

//        List<String> topTen = new ArrayList<>();

        return Arrays.stream(text.split("[\\W\\s\\d]+"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
//                .forEach(e -> topTen.add(e.getKey()));
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

//        return topTen;
    }

    public static List<String> topTenNJ(String text) {
        List<String> words = Arrays.stream(text.split("[\\W\\s]+"))
                .map(String::toLowerCase)
                .sorted()
                .toList();

        Map<String, Integer> wordMap = new HashMap<>();

        words.forEach(word -> wordMap.merge(word, 1, Integer::sum));

        List<String> topTen = new ArrayList<>();

        wordMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(10)
                .forEach(e -> {
//                    System.out.println(e.getKey() + " " + e.getValue());
                    topTen.add(e.getKey());
                });

        return topTen;
    }
}
