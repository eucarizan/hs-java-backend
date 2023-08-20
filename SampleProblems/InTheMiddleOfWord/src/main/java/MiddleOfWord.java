import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiddleOfWord {
    public static String find(String part, String line) {
        Pattern pattern = Pattern.compile("\\B" + part + "\\B", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);

        boolean found = matcher.find();
        return found ? "YES" : "NO";
    }
}
