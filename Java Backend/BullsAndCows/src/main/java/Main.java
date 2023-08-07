import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int length = scanner.nextInt();
            createStringSecretNumber(length);
        }
    }

    private static void createStringSecretNumber(int length) {
        if (length > 10) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            return;
        }

        StringBuilder result = new StringBuilder();
        String str = "";

        while (str.length() < length) {
            str = createResult(str, length);
        }

        result.append(str);

        System.out.println(result);
    }

    private static String createResult(String result, int length) {
        StringBuilder output = new StringBuilder(result);
        long pseudoRandomNumber = System.nanoTime();
        String temp = String.valueOf(Long.parseLong(new StringBuilder(String.valueOf(pseudoRandomNumber)).reverse().toString()));

        for (int i = 0; i < temp.length() && output.length() < length; i++) {
            char ch = temp.charAt(i);
            if (!output.toString().contains(String.valueOf(ch))) {
                output.append(temp.charAt(i));
            }
        }

        return output.toString();
    }
}
