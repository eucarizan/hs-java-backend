import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String botName = "NJChat";
        String birthYear = "2023";

        greet(botName, birthYear);
        remindName();
        guessAge();
        count();
        test();
        end();
    }

    private static void test() {
        System.out.println("Let's test your programming knowledge.");
        String question = """
                Why do we use methods?
                1. To repeat a statement multiple times.
                2. To decompose a program into several small subroutines.
                3. To determine the execution time of a program.
                4. To interrupt the execution of a program.""";
        System.out.println(question);
        int answer = scanner.nextInt();
        while (answer > 3 || answer <= 0) {
            System.out.println("Please, try again.");
            answer = scanner.nextInt();
        }
    }

    private static void end() {
        System.out.println("Congratulations, have a nice day!");
    }

    private static void count() {
        System.out.println("Now I will prove to you that I can count to any number you want.");

        int num = scanner.nextInt();

        for (int i = 0; i <= num; i++) {
            System.out.println(i+"!");
        }
    }

    private static void guessAge() {
        System.out.printf("Let me guess your age.%nEnter remainders of dividing your age by 3, 5, 7.%n");
        int rem3 = scanner.nextInt();
        int rem5 = scanner.nextInt();
        int rem7 = scanner.nextInt();
        int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
        System.out.printf("Your age is %d; that's a good time to start programming!%n", age);
    }

    private static void remindName() {
        System.out.printf("Please, remind me your name.%n");
        String name = scanner.nextLine();
        System.out.printf("What a great name you have, %s!%n", name);
    }

    private static void greet(String assistantName, String birthYear) {
        System.out.printf("Hello! My name is %s.%nI was created in %s.%n", assistantName, birthYear);
    }
}
