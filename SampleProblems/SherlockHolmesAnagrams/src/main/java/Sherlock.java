import java.util.HashMap;
import java.util.Map;

public class Sherlock {
    public static String isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return "no";
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            char ch1 = word1.toLowerCase().charAt(i);
            char ch2 = word2.toLowerCase().charAt(i);
            map1.merge(ch1, 1, Integer::sum);
            map2.merge(ch2, 1, Integer::sum);
        }

        return map1.equals(map2) ? "yes" : "no";
    }
}
