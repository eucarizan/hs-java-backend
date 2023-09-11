import java.util.stream.IntStream;

public class Words {
    public static int createEuphonious(String word) {
        String formattedWord = word.replaceAll("[^aeiouy]", "v").replaceAll("[aeiouy]", "c");
        int count = 0;

        for (int i = 2; i < formattedWord.length(); i++) {
            char prev = formattedWord.charAt(i - 2);
            char mid = formattedWord.charAt(i - 1);
            char curr = formattedWord.charAt(i);

            if (prev == mid && mid == curr) {
                count++;
                i++;
            }
        }

        return count;
    }

    public static long minCharsToEuphonious(String word) {
        return IntStream.range(2, word.length())
                .filter(i -> isDiscordant(word.charAt(i - 2), word.charAt(i - 1), word.charAt(i)))
                .count();
    }

    private static boolean isDiscordant(char prev, char mid, char curr) {
        boolean prevIsVowel = "aeiouy".indexOf(prev) != -1;
        boolean midIsVowel = "aeiouy".indexOf(mid) != -1;
        boolean currIsVowel = "aeiouy".indexOf(curr) != -1;

        //
        return (prevIsVowel && midIsVowel && currIsVowel) ||
                (!prevIsVowel && !midIsVowel && !currIsVowel);

    }
}
