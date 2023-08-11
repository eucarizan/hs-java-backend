package chucknorris;

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please input operation (encode/decode/exit):");
            String command = scanner.nextLine();


            while (!"exit".equals(command)) {
                switch (command) {
                    case "encode" -> {
                        System.out.println("Input string:");
                        String input = scanner.nextLine();
                        encode(input);
                        System.out.println();
                    }
                    case "decode" -> {
                        System.out.println("Input encoded string:");
                        String input = scanner.nextLine();
                        decode(input);
                        System.out.println();
                    }
                    default -> System.out.println("There is no '" + command + "' operation\n");
                }
                System.out.println("Please input operation (encode/decode/exit):");
                command = scanner.nextLine();
            }
            System.out.println("Bye!");
        }
    }

    private static void decode(String input) {
        String[] chars = input.split(" ");
        String binaryString = "";

        if (!input.isEmpty()) {
            binaryString = binaryToString(chars);
        }

        if (binaryString.length() % 7 != 0) {
            System.out.println("Encoded string is not valid");
            return;
        }

        if (!binaryString.isEmpty()) {
            System.out.println("Decoded string:");
            decodeBinary(binaryString);
        }
    }

    private static void encode(String input) {
        String[] chars = input.split("");
        String binaryStr = "";

        if (!input.isEmpty()) {
            binaryStr = stringToBinary(chars);
        }

        System.out.println("Encoded string:");
        encodeBinary(binaryStr);
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

    private static String binaryToString(String[] chars) {
        StringBuilder str = new StringBuilder();

        for (int i = 0, j = 1; i <= chars.length - 2; i += 2, j += 2) {
            if ("00".equals(chars[i])) {
                str.append("0".repeat(Math.max(0, chars[j].length())));
            } else if ("0".equals(chars[i])) {
                str.append("1".repeat(Math.max(0, chars[j].length())));
            } else {
                str.setLength(0);
                System.out.println("Encoded string is not valid");
                return "";
            }
        }

        return str.toString();
    }

    private static void decodeBinary(String binaryString) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i += 7) {
            String str = binaryString.substring(i, i + 7);
            output.append((char) Integer.parseInt(str, 2));
        }

        System.out.println(output);
    }

    private static void encodeBinary(String binaryStr) {
        StringBuilder output = new StringBuilder();
        int count = 1;
        char ch;
        for (int i = 0; i < binaryStr.length(); ) {
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
            output.append(chuckCipherEncode(ch, count));
            count = 1;
        }

        System.out.println(output.toString().trim());
    }

    private static String chuckCipherEncode(char ch, int count) {
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
}
