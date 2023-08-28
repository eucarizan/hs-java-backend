import java.util.List;

public class Words {
    public static long countWithoutRepetitions(int n, List<List<String>> lines) {
        return lines.stream()
                .limit(n)
                .flatMap(List::stream)
                .map(String::toLowerCase)
                .distinct()
                .count();
    }
}
