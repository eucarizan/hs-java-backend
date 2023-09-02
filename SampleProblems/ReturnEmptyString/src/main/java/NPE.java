import java.util.Optional;

public class NPE {
    public static String toUpperCase(String str) {
        return Optional.ofNullable(str).map(String::toUpperCase).orElse("");
    }
}
