enum PasswordStrength { STRONG, MEDIUM, WEAK}
class PasswordUtils {
    public static PasswordStrength getStrength(String password) {
        final String length = ".{8,}";              // at least 8 chars long
        final String lowercase = "(?=.*[a-z])";     // at least one lowercase char
        final String uppercase = "(?=.*[A-Z])";     // at least one uppercase char
        final String digit = "(?=.*\\d)";           // at least one digit
        final String special = "(?=.*[ !@#$%^&*])"; // at least one of these special chars

        if (password.matches(lowercase + uppercase + digit + special + length)) {
            return PasswordStrength.STRONG;
        } else if (password.matches(lowercase + digit + length)) {
            return PasswordStrength.MEDIUM;
        } else if (password.matches(uppercase + digit + length)) {
            return PasswordStrength.MEDIUM;
        } else {
            return PasswordStrength.WEAK;
        }
    }
}
