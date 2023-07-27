import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String[] hands = {"paper", "scissors", "rock"};
        StringBuilder response = new StringBuilder();

        String msgLoss = "Sorry, but the computer chose %s";
        String msgDraw = "There is a draw (%s)";
        String msgWin = "Well done. The computer chose %s and failed";

        String user = scanner.nextLine();
        Random random = new Random();
        String compHand = hands[random.nextInt(3)];

        // computer win
        boolean paperScissors = user.equals(hands[0]) && compHand.equals(hands[1]);
        boolean scissorsRock = user.equals(hands[1]) && compHand.equals(hands[2]);
        boolean rockPaper = user.equals(hands[2]) && compHand.equals(hands[0]);

        if (paperScissors || scissorsRock || rockPaper) {
            response.append(String.format(msgLoss, compHand));
        } else if (user.equals(compHand)) {
            response.append(String.format(msgDraw, compHand));
        } else {
            response.append(String.format(msgWin, compHand));
        }

        System.out.println(response);
    }
}
