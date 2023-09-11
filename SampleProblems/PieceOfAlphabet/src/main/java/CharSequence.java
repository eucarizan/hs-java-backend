public class CharSequence {
    public static boolean isPieceOfAlphabet(String word) {
        if (word.matches("[0-9]+")) {
            return false;
        }

        String chars = word.toLowerCase();

        for (int i = 1; i < chars.length(); i++) {
            char prev = chars.charAt(i - 1);
            char curr = chars.charAt(i);

            if (prev + 1 != curr) {
                return false;
            }
        }
        return true;
    }
}
