import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String botName = "NJChat";
        int birthYear = 2023;

        System.out.printf("Hello! My name is %s.%nI was created in %d.%nPlease, remind me your name.%n", botName, birthYear);

        String name = scanner.nextLine();

        System.out.printf("What a great name you have, %s!", name);
    }
}
