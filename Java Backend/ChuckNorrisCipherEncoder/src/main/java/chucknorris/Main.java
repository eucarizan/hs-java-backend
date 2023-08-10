package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input string:");
        String text = new Scanner(System.in).nextLine();

        System.out.println();
        System.out.println("The result:");

        String[] binaryWords = unaryToBinary(text).split("(?<=\\G.{7})");
        for (String binaryWord : binaryWords) {
            System.out.print((char) Integer.parseInt(binaryWord, 2));
        }
    }

    private static String unaryToBinary(String unarySequence) {
        String[] unarySequenceParts = unarySequence.split(" ");
        String binarySequence = "";

        for (int i = 0; i < unarySequenceParts.length; i += 2) {
            binarySequence += (unarySequenceParts[i].equals("00") ? "0" : "1").repeat(unarySequenceParts[i + 1].length());
        }

        return binarySequence;
    }
}