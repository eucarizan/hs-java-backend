import java.util.Optional;
import java.util.stream.Stream;

public class Utils {
    public static long countPasswords(Stream<String> passwordStream) {

        return passwordStream.count();
    }
}
