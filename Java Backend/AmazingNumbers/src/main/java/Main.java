import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a natural number:");
            int num = scanner.nextInt();

            if (num < 1) {
                System.out.println("This number is not natural");
                return;
            }

            if (num % 2 == 0) {
                System.out.println("This number is even.");
            } else {
                System.out.println("This number is odd.");
            }

            numberBuzz(num);
        }
    }

    private static void numberBuzz(int num) {
        StringBuilder sb = new StringBuilder();
        int digit = num % 10;

        if (num % 7 == 0 && digit == 7) {
            sb.append("It is a Buzz number.\n");
            sb.append("Explanation:\n");
            sb.append(num);
            sb.append(" is divisible by 7 and ends with 7.");
        } else if (num % 7 == 0) {
            sb.append("It is a Buzz number.\n");
            sb.append("Explanation:\n");
            sb.append(num);
            sb.append(" is divisible by 7.");
        } else if (digit == 7) {
            sb.append("It is a Buzz number.\n");
            sb.append("Explanation:\n");
            sb.append(num);
            sb.append(" ends with 7.");
        } else {
            sb.append("It is not a Buzz number.\nExplanation:\n");
            sb.append(num);
            sb.append(" is neither divisible by 7 nor does it end with 7.");
        }

        System.out.println(sb);
    }
}
