package chucknorris;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Input string:");
            String input = scanner.nextLine();
            String[] chars = input.split("");
            String binaryStr = "";

            if (!input.isEmpty()) {
                binaryStr = stringToBinary(chars);
            }

            System.out.println("The result:");

            binaryToZero(binaryStr);
        }
    }

    private static void binaryToZero(String binaryStr) {
        StringBuilder output = new StringBuilder();
        int count = 1;
        char ch = ' ';
        for (int i = 0; i < binaryStr.length();) {
            ch = binaryStr.charAt(i);

            for (int j = i + 1; j < binaryStr.length(); j++) {
                char ch2 = binaryStr.charAt(j);
                if (ch == ch2) {
                    count++;
                } else {
                    break;
                }
            }
            i += count;
            output.append(chuckCipher(ch, count));
            count = 1;
        }

        System.out.println(output);
    }

    private static String chuckCipher(char ch, int count) {
        StringBuilder chuck = new StringBuilder();
        if (ch == '1') {
            chuck.append("0 ");
        } else {
            chuck.append("00 ");
        }

        chuck.append("0".repeat(Math.max(0, count)));
        chuck.append(" ");

        return chuck.toString();
    }

    private static String stringToBinary(String[] input) {
        StringBuilder str = new StringBuilder();
        Arrays.stream(input)
                .forEach(s -> {
                    String digits = Integer.toBinaryString(s.charAt(0));
                    str.append(String.format("%07d", Integer.parseInt(digits)));
                });

        return str.toString();
    }
}
