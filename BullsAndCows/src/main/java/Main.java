import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final int MAX_LENGTH = 36;

            // #1 get length of secret code
            // #1.1 if length > 36 and if length < 1 repeat #1
            // #1.2 invalid number "abc 0 -7"
            int length = 0;
            String input = "";

            do {
                System.out.println("Input the length of the secret code:");
                try {
                    input = scanner.nextLine();
                    length = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Error: \"" + input + "\" isn't a valid number.");
                    return;
                }

                if (length > MAX_LENGTH) {
                    System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                    return;
                }
            } while (length < 0);
            // } while (length < 0 || length > MAX_LENGTH);

            // #2 get number of possible characters (chars)
            // TODO-02 #2.1 if chars < length repeat #2
            // #2.1.1 "Error: it's not possible to generate a code with a length of (length) with (chars < length) unique symbols."
            int chars = 0;
            System.out.println("Input the number of possible symbols in the code:");
            chars = Integer.parseInt(scanner.nextLine());

            if (chars < length) {
                System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.%n", length, chars);
                return;
            }

            if (chars > MAX_LENGTH) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                return;
            }

            // #3 generate secret code, print secret code using `*`, print which characters were used to generate secret code
            // #3.2 print secret code using `*`
            // #3.3 print which characters
            String secretNumber = SecretNumber.generateSecretNumber(length, chars);

            // #4 start game
            // #4.1 get user input (guess)
            // #4.2 grade guess
            // #4.2.1 if all are bull end game
            Game game = new Game(secretNumber);
            game.play(scanner);
        }
    }

    private static String createSecretNumber(int length) {
        // ANOTHER STRATEGY create a List of chars 0-9 a-z using list.of() method
        // ANOTHER STRATEGY create secret number using ArrayList copy from field List
        // if chars > 10 then use letters
        // remove unnecessary chars (e.g. chars = 12, secretNumber should only contain 0-9 a-b)

        final long pseudoRandomNumber = System.nanoTime();

        final long[] lowerBound = { 1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000 };
        final long[] upperBound = { 9, 99, 999, 9_999, 99_999, 999_999, 9_999_999, 99_999_999, 999_999_999, 9_999_999_999L };
        final Random random = new Random(pseudoRandomNumber);
        final int index = length - 1;

        long num = random.nextLong(lowerBound[index], upperBound[index]);

        while (isDistinct(num, length)) {
            num = random.nextLong(lowerBound[index], upperBound[index]);
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

class SecretNumber {
    static StringBuilder temp = new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyz");
    static final Random random = new Random();
    
    public static String generateSecretNumber(int length, int chars) {
        StringBuilder secretNumber = new StringBuilder();

        temp.delete(chars, temp.length());

        while (secretNumber.length() < length) {
            int index = random.nextInt(0, temp.length());
            char ch = temp.charAt(index);
            secretNumber.append(ch);
            temp.deleteCharAt(index);
        }

        printSecretPrepared(length, chars);

        return secretNumber.toString();
    }

    private static void printSecretPrepared(int length, int chars) {
        System.out.print("The secret is prepared: ");

        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }

        if (chars <= 10 && chars > 1) {
            System.out.println(" (0-" + (chars - 1) + ").");
        } else {
            if (chars == 11) {
                System.out.println(" (0-9, a).");
            } else {
                System.out.println(" (0-9, a-" + (char) (86 + chars) + ").");
            }
        }
    }
}

class Game {

    String secretNumber = "";
    boolean guessed = false;

    public Game(String secretNumber) {
        this.secretNumber = secretNumber;
    }

    public void play(Scanner scanner) {
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

    private int count(String guess) {
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
        // TODO-06 use contains to check cows
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
}