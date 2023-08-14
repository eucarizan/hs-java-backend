import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to Amazing Numbers!");
            String options = """
                    \nSupported requests:
                    - enter a natural number to know its properties;
                    - enter two natural numbers to obtain the properties of the list:
                      * the first parameter represents a starting number;
                      * the second parameter shows how many consecutive numbers are to be processed;
                    - separate the parameters with one space;
                    - enter 0 to exit.""";
            System.out.println(options);

            long num = -1;
            long count = -1;
            boolean hasCount = false;

            do {
                try {
                    System.out.print("\nEnter a request: ");
                    String input = scanner.nextLine();

                    if ("".equals(input)) {
                        System.out.println(options);
                        continue;
                    }

                    String[] strings = input.split(" ");

                    num = Long.parseLong(strings[0]);

                    if (strings.length > 1) {
                        count = Long.parseLong(strings[1]);
                        hasCount = true;
                    }

                    System.out.println();

                    if (num >= 1 && !hasCount) {
                        Number number = new Number(num);
                        System.out.println(number);
                    } else if (num < 0) {
                        System.out.println("The first parameter should be a natural number or zero");
                    } else if (hasCount && count < 0) {
                        System.out.println("The second parameter should be a natural number");
                    } else if (hasCount) {
                        for (int i = 0; i < count; i++) {
                            Number number = new Number(num + i);
                            number.getProperties();
                        }
                        hasCount = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(options);
                }
            } while (num != 0);

            System.out.println("Goodbye!");
        }
    }
}

@SuppressWarnings("unused")
class Number {

    long number;

    public Number(long number) {
        this.number = number;
    }

    private boolean isBuzz() {
        long digit = number % 10;

        return number % 7 == 0 || digit == 7;
    }

    private boolean isEven() {
        return number % 2 == 0;
    }

    private boolean isDuck() {
        String strN = String.valueOf(number);
        return strN.contains("0") && strN.lastIndexOf("0") > 0;
    }

    private boolean isDuckLong() {
        String str = String.valueOf(number);
        String num = removeLeadingZeros(str);

        return num.contains("0");
    }

    private String removeLeadingZeros(String str) {
        int ind = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != '0') {
                ind = i;
                break;
            }
        }

        return str.substring(ind);
    }

    private boolean isPalindrome() {
        String str = String.valueOf(number);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        return str.contentEquals(sb);
    }

    private boolean isGapful() {
        String numStr = String.valueOf(number);

        if (numStr.length() < 3) {
            return false;
        }

        int gap = Integer.parseInt(numStr.charAt(0) + "" + numStr.charAt(numStr.length() - 1));
        return number % gap == 0;
    }

    public void getProperties() {
        List<String> properties = new ArrayList<>();

        if (isEven()) {
            properties.add("even");
        } else {
            properties.add("odd");
        }

        if (isBuzz()) {
            properties.add("buzz");
        }

        if (isDuck()) {
            properties.add("duck");
        }

        if (isPalindrome()) {
            properties.add("palindromic");
        }

        if (isGapful()) {
            properties.add("gapful");
        }

        System.out.println(number + " is " + String.join(", ", properties));
    }

    @Override
    public String toString() {
        return "Properties of " + number +
                "\neven: " + isEven() +
                "\nodd: " + !isEven() +
                "\nbuzz: " + isBuzz() +
                "\nduck: " + isDuck() +
                "\npalindromic: " + isPalindrome() +
                "\ngapful: " + isGapful();
    }
}