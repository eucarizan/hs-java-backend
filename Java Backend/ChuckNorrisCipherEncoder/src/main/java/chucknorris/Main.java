package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Input string:");
            String[] input = scanner.nextLine().split("");
            System.out.println(String.join(" ", input));
        }
    }
}
