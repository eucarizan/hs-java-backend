public class Main {
    public static void main(String[] args) {
        System.out.println(modifyString("my password is 12345"));
    }

    static String modifyString(String initialString) {
        String modString = initialString;

        modString = modString.substring(0, 2) + modString.substring(10); // 1
        if (modString.contains(" ")) { // 2
            modString += "ABC";
        }
        int space = modString.indexOf(" ");
        modString = modString.substring(space + 1) + modString.substring(0, space); // 3
        if (modString.contains("a")) { // 4
            modString += "1248";
        }
        modString = modString.replaceFirst("\\s", "\\$"); // 5
        if (modString.length() < 15) { // 6
            modString = new StringBuilder(modString).reverse().toString();
        }
        modString += "18B20"; // 7
        int one = modString.indexOf("1");
        int five = modString.indexOf("5");
        modString = modString.substring(one + 1) + modString.substring(0, five); // 8
        modString.substring(0, modString.length() - 4); // 9

        return modString;
    }
}