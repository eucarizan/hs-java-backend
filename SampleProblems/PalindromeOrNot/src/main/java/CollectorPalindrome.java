import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorPalindrome {

    public static Map<Boolean, List<String>> isPalindrome(String[] words) {
        return Arrays.stream(words).collect(
                Collectors.partitioningBy(CollectorPalindrome::checkPalindrome));
    }

    private static boolean checkPalindrome(String word) {
        String cleanedWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return cleanedWord.contentEquals(new StringBuilder(cleanedWord).reverse());
    }


    private static boolean checkPalindromeStream(String word) {
        String cleanWord = word.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return IntStream.range(0, cleanWord.length() / 2)
                .allMatch(i -> cleanWord.charAt(i) == cleanWord.charAt(cleanWord.length() - 1 - i));
    }

    public static Map<Boolean, List<String>> isPalindromeNJ(String[] words) {
        return Arrays.stream(words).collect(Collectors.partitioningBy(word -> {
            StringBuilder sb = new StringBuilder(word);
            return word.contentEquals(sb.reverse());
        }));
    }
}
