import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final String msgLoss = "Sorry, but the computer chose %s";
    static final String msgDraw = "There is a draw (%s)";
    static final String msgWin = "Well done. The computer chose %s and failed";
    static final String[] hands = {"paper", "scissors", "rock"};

    static String playerName;
    static int rating = 0;

    public static void main(String[] args) throws FileNotFoundException {
        play();
    }

    private static void play() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(System.in)) {
            getPlayerName(scanner);
            setPlayerRating();

            String userHand = scanner.nextLine();

            while (!userHand.equals("!exit")) {
                switch (userHand) {
                    case "rock", "paper", "scissors" -> getResult(userHand);
                    case "!rating" -> System.out.println("Your rating: " + rating);
                    default -> System.out.println("Invalid input");
                }
                userHand = scanner.nextLine();
            }
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
                rating += 50;
                return String.format(msgDraw, compHand);
            }
            default -> {
                rating += 100;
                return String.format(msgWin, compHand);
            }
        }
    }

    private static void getPlayerName(Scanner scanner) {
        System.out.print("Enter your name: ");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName);
    }

    private static void setPlayerRating() throws FileNotFoundException {
        String pathToFile = "rating.txt";
        File file = new File(pathToFile);
        boolean playerInFile = false;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");

                if (line[0].equals(playerName)) {
                    rating = Integer.parseInt(line[1]);
                    playerInFile = true;
                    break;
                }
            }
        }

        if (!playerInFile) {
            rating = 0;
        }
    }
}
