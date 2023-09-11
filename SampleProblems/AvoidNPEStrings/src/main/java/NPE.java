public class NPE {
    public static String concatStrings(String str1, String str2) {
        if (str1 == null) {
            str1 = "";
        }

        if (str2 == null) {
            str2 = "";
        }

        return str1.concat(str2);
    }
}
