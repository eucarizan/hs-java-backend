import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String botName = "NJChat";
        int birthYear = 2023;

        System.out.printf("Hello! My name is %s.%nI was created in %d.%n", botName, birthYear);
        System.out.printf("Please, remind me your name.%n");

        String name = scanner.nextLine();

        System.out.printf("What a great name you have, %s!%n", name);
        System.out.printf("Let me guess your age.%nEnter remainders of dividing your age by 3, 5, 7.%n");

        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        System.out.printf("Your age is %d; that's a good time to start programming!%n", age);
        System.out.println("Now I will prove to you that I can count to any number you want.");

        int num = scanner.nextInt();

        for (int i = 0; i <= num; i++) {
            System.out.println(i+"!");
        }

        System.out.println("Completed, have a nice day!");
    }
}
