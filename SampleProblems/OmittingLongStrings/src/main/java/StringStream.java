import java.util.List;
import java.util.stream.Stream;

public class StringStream {
    public static Stream<String> omitLongStrings(List<String> strings) {
        final int maxLength = 4;

        return strings.stream()
                .filter(str -> str.length() < maxLength);
    }
}
