import java.util.Comparator;
import java.util.List;

public class Words {
    public static String longest(List<String> words) {
        return words.stream()
                .sorted(Comparator
                        .comparingInt(String::length)
                        .reversed())
                .limit(1)
                .toList()
                .toString()
                .replaceAll("\\[", "")
                .replaceAll("]", "");
    }
}
