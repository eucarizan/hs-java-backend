import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a natural number:");
            int num = scanner.nextInt();

            if (num < 1) {
                System.out.println("This number is not natural");
            } else {
                Number number = new Number(num);
                System.out.println(number);
            }
        }
    }
}

@SuppressWarnings("unused")
class Number {

    int number;

    public Number(int number) {
        this.number = number;
    }

    private boolean isBuzz() {
        int digit = number % 10;

        return number % 7 == 0 || digit == 7;
    }

    private boolean isEven() {
        return number % 2 == 0;
    }

    private boolean isDuckWhile() {
        int n = number;
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

    @Override
    public String toString() {
        return "Properties of " + number +
                "\neven: " + isEven() +
                "\nodd: " + !isEven() +
                "\nbuzz: " + isBuzz() +
                "\nduck: " + isDuck();
    }
}