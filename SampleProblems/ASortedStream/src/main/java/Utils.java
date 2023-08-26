import java.util.List;
import java.util.stream.Stream;

public class Utils {
    public static List<String> sortPrint(Stream<String> stream) {
        return stream.sorted().toList();
    }
}
