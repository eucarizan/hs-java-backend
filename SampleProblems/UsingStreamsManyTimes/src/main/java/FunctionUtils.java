import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FunctionUtils {
    public static <T> Supplier<Stream<T>> saveStream(Stream<T> stream) {
        List<T> list = stream.toList();
        return list::stream;
    }
}
