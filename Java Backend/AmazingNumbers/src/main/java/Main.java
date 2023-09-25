import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to Amazing Numbers!");
            System.out.println(Program.OPTIONS);

            String output;

            do {
                System.out.print("\nEnter a request: ");
                String input = scanner.nextLine();
                output = Program.processRequest(input);
                System.out.print(output);
            } while (!"\nGoodbye!".equals(output));
        }
    }
}