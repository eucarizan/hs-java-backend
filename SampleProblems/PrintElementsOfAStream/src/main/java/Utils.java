import java.util.List;
import java.util.stream.Stream;

public class Utils {
    public static List<Integer> printStream(Stream<Integer> stream) {
        return stream.skip(2).toList();
    }
}
