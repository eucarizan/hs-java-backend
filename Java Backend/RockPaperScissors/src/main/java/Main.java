import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String[] hands = {"paper", "scissors", "rock"};
        StringBuilder response = new StringBuilder("Sorry, but the computer chose ");

        String input = scanner.nextLine();

        if (input.equals(hands[0])) {
            response.append(hands[1]);
        } else if (input.equals(hands[1])) {
            response.append(hands[2]);
        } else if (input.equals(hands[2])) {
            response.append(hands[0]);
        }

        System.out.println(response);
    }
}
