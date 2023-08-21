import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static List<String> find(String text) {
        Pattern pattern = Pattern.compile("password\\W+(\\w*)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        if (!matcher.find()) {
            return List.of("No passwords found.");
        } else {
            matcher.reset();
        }

        List<String> passwords = new ArrayList<>();
        while (matcher.find()) {
            String password = matcher.group(1);
            passwords.add(password);
        }

        return passwords;
    }

    public static void findStream(String text) {
        if (Pattern.compile("(?i)password[\\s:]*(\\w+)")
                .matcher(text).results()
                .map(mr -> mr.group(1))
                .peek(System.out::println).count() == 0) {
            System.out.println("No passwords found.");
        }
    }
}
