package chucknorris;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Input string:");
            String input = scanner.nextLine();
            String[] chars = input.split("");

            System.out.println("The result:");
            if (!input.isEmpty()) {
                stringToBinary(chars);
            }
        }
    }

    private static void stringToBinary(String[] input) {
        Arrays.stream(input)
                .forEach(s -> {
                    String digits = Integer.toBinaryString(s.charAt(0));
                    System.out.printf("%s = %07d%n", s, Integer.parseInt(digits));
                });
    }
}
