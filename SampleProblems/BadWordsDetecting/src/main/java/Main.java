import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String input = "a bad boy bought would buyght like to buy a something bad;a bad boy bought would buyght like to buy something";
        String[] parts = input.split(";");

        String text = parts[0];
        List<String> dict = parts.length > 1 ?
                Arrays.asList(parts[1].split(" ")) :
                Collections.singletonList("");

        System.out.println(BadWordsDetector.createBadWordsDetectingStream(text, dict).collect(Collectors.toList()));
    }
}