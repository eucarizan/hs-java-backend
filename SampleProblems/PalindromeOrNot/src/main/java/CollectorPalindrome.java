import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorPalindrome {

    public static Map<Boolean, List<String>> isPalindrome(String[] words) {
        return Arrays.stream(words).collect(
                Collectors.partitioningBy(word -> word.contentEquals(new StringBuilder(word).reverse()))
        );
    }

    public static Map<Boolean, List<String>> isPalindromeNJ(String[] words) {
        return Arrays.stream(words).collect(
                Collectors.partitioningBy(word -> {
                    StringBuilder sb = new StringBuilder(word);
                    return word.contentEquals(sb.reverse());
                })
        );
    }
}
