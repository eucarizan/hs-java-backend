import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ASCIIArt {

    public static String asciiArt(List<String> symbols) {
        return symbols.stream()
                .collect(Collectors.joining("", "(", ")"));
    }

    public static String putParen(List<String> symbols) {
        List<String> art = new ArrayList<>();
        art.add("(");
        art.addAll(symbols);
        art.add(")");
        return String.join("", art);
    }
}
