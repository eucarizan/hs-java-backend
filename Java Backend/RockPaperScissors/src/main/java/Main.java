import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final String msgLoss = "Sorry, but the computer chose %s";
    static final String msgDraw = "There is a draw (%s)";
    static final String msgWin = "Well done. The computer chose %s and failed";
    static String[] hands = {"rock", "paper", "scissors"};
    static int half = 1;
    static String playerName;
    static int rating = 0;
    static final Random random = new Random();

    public static void main(String[] args) throws FileNotFoundException {
        play();
    }

    private static void play() throws FileNotFoundException {
        try (Scanner scanner = new Scanner(System.in)) {
            getPlayerName(scanner);
            setPlayerRating();
            setOptions(scanner);

            String userHand = scanner.next();

            while (!userHand.equals("!exit")) {
                if (Arrays.asList(hands).contains(userHand)) {
                    getResult(userHand);
                } else if ("!rating".equals(userHand)) {
                    System.out.println("Your rating: " + rating);
                } else {
                    System.out.println("Invalid input");
                }
                userHand = scanner.next();
            }
        }
        System.out.println("Bye!");
    }

    private static void getResult(String userHand) {
        StringBuilder response = new StringBuilder();

        int compHandIdx = random.nextInt(hands.length);
        String compHand = hands[compHandIdx];

        if (userHand.equals(compHand)) {
            response.append(getResultMsg("draw", compHand));
        } else {
            int userHandIdx = getUserHandIdx(userHand);
            boolean compWin = isComputerWin(compHandIdx, userHandIdx);

            if (compWin) {
                response.append(getResultMsg("loss", compHand));
            } else {
                response.append(getResultMsg("win", compHand));
            }
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

    private static void setOptions(Scanner scanner) {
        String input = scanner.nextLine();
        // rock,gun,lightning,devil,dragon,water,air,paper,sponge,wolf,tree,human,snake,scissors,fire

        if (!"".equals(input)) {
            hands = input.split(",");
        }

        half = hands.length / 2;
        System.out.println("Okay, let's start");
    }

    private static int getUserHandIdx(String userHand) {
        int idx = 0;

        for (int i = 0; i < hands.length; i++) {
            if (hands[i].equals(userHand)) {
                idx = i;
                break;
            }
        }

        return idx;
    }

    private static boolean isComputerWin(int compHandIdx, int userHandIdx) {
        int startIdx = userHandIdx;
        if (userHandIdx + half > hands.length - 1) {
            startIdx = 0;
        }

        boolean lowerBound = compHandIdx >= startIdx + 1;
        boolean upperBound = compHandIdx <= startIdx + half;

        return lowerBound && upperBound;
    }
}
