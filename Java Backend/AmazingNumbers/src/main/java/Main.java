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
                    - two natural numbers and a property to search for;
                    - separate the parameters with one space;
                    - enter 0 to exit.""";
            System.out.println(options);

            long num = -1;
            long count = -1;
            boolean hasCount = false;
            String property = "";

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

                    if (strings.length == 1 && num == 0) {
                        System.out.println();
                        break;
                    } else if (num < 0) {
                        System.out.println("\nThe first parameter should be a natural number or zero");
                    } else if (strings.length == 1) {
                        Number number = new Number(num);
                        System.out.println(number);
                    } else {
                        count = Long.parseLong(strings[1]);

                        if (strings.length == 3) {
                            property = strings[2].toLowerCase();
                            if (!"evenoddbuzzduckpalindromicgapfulspy".contains(property)) {
                                System.out.println("The property [" + property.toUpperCase() + "] is wrong.");
                                System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD]");
                            } else {
                                // only numbers with indicated property should be printed
                                int j = 0;
                                for (int i = 0; i < count; i++) {
                                    Number number = new Number(num + j++);
                                    while (!number.hasProperty(property)) {
                                        number = new Number(num + j++);
                                    }
                                    number.getProperties();
                                }
                            }
                        }

                        if (count < 0) {
                            System.out.println("\nThe second parameter should be a natural number");
                        } else if (property.isEmpty()) {
                            for (int i = 0; i < count; i++) {
                                Number number = new Number(num + i);
                                number.getProperties();
                            }
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nThe first parameter should be a natural number or zero");
                }
            } while (num != 0);

            System.out.println("Goodbye!");
        }
    }
}

@SuppressWarnings("unused")
class Number {

    long number;
    boolean buzz;
    boolean duck;
    boolean palindromic;
    boolean gapful;
    boolean spy;
    boolean even;
    boolean odd;


    public Number(long number) {
        this.number = number;
        this.buzz = isBuzz();
        this.duck = isDuck();
        this.palindromic = isPalindromic();
        this.gapful = isGapful();
        this.spy = isSpy();
        this.even = isEven();
        this.odd = !isEven();
    }

    public boolean hasProperty(String property) {

        return switch (property) {
            case "buzz" -> buzz;
            case "duck" -> duck;
            case "palindromic" -> palindromic;
            case "gapful" -> gapful;
            case "spy" -> spy;
            case "even" -> even;
            case "odd" -> odd;
            default -> false;
        };
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

    private boolean isPalindromic() {
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

    private boolean isSpy() {
        long temp = number;
        long sum = 0;
        long product = 1;

        while (temp > 0) {
            sum += temp % 10;
            product *= (long) ((double) temp % 10);
            temp = temp / 10;
        }

        return sum == product;
    }

    public void getProperties() {
        List<String> properties = new ArrayList<>();

        if (buzz) {
            properties.add("buzz");
        }

        if (duck) {
            properties.add("duck");
        }

        if (palindromic) {
            properties.add("palindromic");
        }

        if (gapful) {
            properties.add("gapful");
        }

        if (spy) {
            properties.add("spy");
        }

        if (even) {
            properties.add("even");
        } else {
            properties.add("odd");
        }

        System.out.println(number + " is " + String.join(", ", properties));
    }

    @Override
    public String toString() {
        return "Properties of " + number +
                "\nbuzz: " + buzz +
                "\nduck: " + duck +
                "\npalindromic: " + palindromic +
                "\ngapful: " + gapful +
                "\nspy: " + spy +
                "\neven: " + even +
                "\nodd: " + odd;
    }
}