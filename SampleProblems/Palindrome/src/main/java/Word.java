public class Word {
    public static boolean isPalindrome(String word) {
        String cleanWord = word.toLowerCase().replaceAll("[^a-z]", "");
        StringBuilder sb = new StringBuilder(cleanWord);

        return cleanWord.contentEquals(sb.reverse());
    }
}
