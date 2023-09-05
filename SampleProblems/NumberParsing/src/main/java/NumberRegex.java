public class NumberRegex {
    public static String isNumber(String text) {
        return text.trim()
                .matches("^[+-]?(0|[1-9][0-9]*)([.,]0+|[.,][0-9]*[1-9])?(\\.0+)?$") ? "YES" : "NO";
    }
}
