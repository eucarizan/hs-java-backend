import java.util.List;
import java.util.stream.Collectors;

public class Codes {
    public static List<String> extract(List<String> codes) {
        if (codes.isEmpty()) {
            return List.of();
        }

        return codes.stream()
                .dropWhile(code -> !"#0000".equals(code))
                .takeWhile(code -> !"#FFFF".equals(code))
                .skip(1)
                .collect(Collectors.toList());
    }

}
