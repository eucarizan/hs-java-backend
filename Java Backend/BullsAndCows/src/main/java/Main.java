import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {
    static String secretNumber;
    static boolean guessed = false;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            String tempSecretNumber = "";
            do {
                System.out.println("Please, enter the secret code's length");
                int length = Integer.parseInt(scanner.nextLine());
                tempSecretNumber = createSecretNumber(length);
            } while ("recreate".equals(tempSecretNumber));

            secretNumber = tempSecretNumber;
            play(scanner);
        }
    }

    private static void play(Scanner scanner) {
        System.out.println("Okay, let's start a game!");
        int turn = 1;
        final int bullCount = secretNumber.length();

        while (!guessed) {
            System.out.println("Turn " + turn++ + ":");
            String guess = scanner.nextLine();
            if (bullCount == count(guess)) {
                guessed = true;
            }
        }

        System.out.println("Congratulations! You guessed the secret code.");
    }

    private static int count(String guess) {
        int bullCount = 0;
        int cowCount = 0;
        int length = secretNumber.length();

        for (int i = 0; i < length; i++) {
            char secretNumberCh = secretNumber.charAt(i);
            for (int j = 0; j < length; j++) {
                char guessNumberCh = guess.charAt(j);
                if (i == j && secretNumberCh == guessNumberCh) {
                    bullCount++;
                } else if (secretNumberCh == guessNumberCh) {
                    cowCount++;
                }
            }
        }

        print(bullCount, cowCount);

        return bullCount;
    }

    private static void print(int bullCount, int cowCount) {
        StringBuilder strOut = new StringBuilder("Grade: ");

        if (bullCount > 0) {
            strOut.append(String.format("%d bull", bullCount));
//            strOut.append(String.format("%d bull(s)", bullCount));
        }
        if (bullCount > 0 && cowCount > 0) {
            strOut.append(" and ");
        }
        if (cowCount > 0) {
            strOut.append(String.format("%d cow", cowCount));
            // strOut.append(String.format("%d cow(s)", cowCount));
        }

        if (bullCount == 0 && cowCount == 0) {
            strOut.append("None");
        }

        System.out.println(strOut);
        // System.out.println(strOut.append(String.format(". The secret code is %s.", secretNumber)));
    }

    private static String createSecretNumber(int length) {
        final long pseudoRandomNumber = System.nanoTime();

        final long[] lowerBound = { 1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000 };
        final long[] upperBound = { 9, 99, 999, 9_999, 99_999, 999_999, 9_999_999, 99_999_999, 999_999_999, 9_999_999_999L };
        final Random random = new Random(pseudoRandomNumber);
        final int index = length - 1;

        if (length > 10) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            // System.out.println("Error: can't generate a secret number with a length > 10 because there aren't enough unique digits.");
            return "recreate";
        }

        long num = random.nextLong(lowerBound[index], upperBound[index]);
        char digit0 = String.valueOf(num).charAt(0);

        while (digit0 == '0' || isDistinct(num, length)) {
            num = random.nextLong(lowerBound[index], upperBound[index]);
            digit0 = String.valueOf(num).charAt(0);
        }

        return String.valueOf(num);
    }

    private static boolean isDistinct(long num, int length) {
        String number = String.valueOf(num);
        int count = 0;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (number.charAt(i) == number.charAt(j)) {
                    count++;
                    break;
                }
            }
            if (count > 0) break;
        }

        return count != 0;
    }
}
