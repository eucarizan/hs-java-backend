import java.util.Random;
import java.util.Scanner;

public class Main {
    static final String msgLoss = "Sorry, but the computer chose %s";
    static final String msgDraw = "There is a draw (%s)";
    static final String msgWin = "Well done. The computer chose %s and failed";
    static final String[] hands = {"paper", "scissors", "rock"};

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        Scanner scanner = new Scanner(System.in);

        String userHand = scanner.nextLine();

        while (!userHand.equals("!exit")) {
            switch (userHand) {
                case "rock", "paper", "scissors" -> getResult(userHand);
                default -> System.out.println("Invalid input");
            }
            userHand = scanner.nextLine();
        }

        System.out.println("Bye!");
    }

    private static void getResult(String userHand) {
        StringBuilder response = new StringBuilder();

        Random random = new Random();
        String compHand = hands[random.nextInt(3)];

        // computer win
        boolean paperScissors = userHand.equals(hands[0]) && compHand.equals(hands[1]);
        boolean scissorsRock = userHand.equals(hands[1]) && compHand.equals(hands[2]);
        boolean rockPaper = userHand.equals(hands[2]) && compHand.equals(hands[0]);

        if (paperScissors || scissorsRock || rockPaper) {
            response.append(getResultMsg("loss", compHand));
        } else if (userHand.equals(compHand)) {
            response.append(getResultMsg("draw", compHand));
        } else {
            response.append(getResultMsg("win", compHand));
        }

        System.out.println(response);
    }

    private static String getResultMsg(String result, String compHand) {
        switch (result) {
            case "loss" -> {
                return String.format(msgLoss, compHand);
            }
            case "draw" -> {
                return String.format(msgDraw, compHand);
            }
            default -> {
                return String.format(msgWin, compHand);
            }
        }
    }
}
