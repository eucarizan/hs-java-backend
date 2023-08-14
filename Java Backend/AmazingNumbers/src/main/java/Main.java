import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to Amazing Numbers!");
            System.out.println("\nSupported requests:\n- enter a natural number to know its properties;\n- enter 0 to exit.");

            long num = -1;

            do {
                System.out.print("\nEnter a request: ");
                num = scanner.nextLong();

                System.out.println();

                if (num >= 1) {
                    Number number = new Number(num);
                    System.out.println(number);
                } else if (num < 0) {
                    System.out.println("The first parameter should be a natural number or zero");
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

    private boolean isDuckWhile() {
        long n = number;
        boolean duck = false;
        while (n > 0) {
            if (n % 10 == 0) {
                duck = true;
            }
            n /= 10;
        }
        return duck;
    }

    private boolean isDuck() {
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

    @Override
    public String toString() {
        return "Properties of " + number +
                "\neven: " + isEven() +
                "\nodd: " + !isEven() +
                "\nbuzz: " + isBuzz() +
                "\nduck: " + isDuck() +
                "\npalindromic: " + isPalindrome();
    }
}