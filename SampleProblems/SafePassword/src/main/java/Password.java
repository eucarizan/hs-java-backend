public class Password {
    public static String isSafe(String password) {
        final int minLength = 12;
        String lowerCase = ".*[a-z]+.*";
        String upperCase = ".*[A-Z]+.*";
        String digits = ".*[0-9]+.*";

        boolean safePassword =
                password.matches(lowerCase) &&
                password.matches(upperCase) &&
                password.matches(digits) &&
                password.length() >= minLength;

        return safePassword ? "YES" : "NO";
    }
}
