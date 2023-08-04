import java.util.Scanner;

public class Main {
    static final String secretNumber = "1234";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String guess = scanner.nextLine();

            count(guess);
        }
    }

    private static void count(String guess) {
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
    }

    private static void print(int bullCount, int cowCount) {
        StringBuilder strOut = new StringBuilder("Grade: ");

        if (bullCount > 0) {
            strOut.append(String.format("%d bull(s)", bullCount));
        }
        if (bullCount > 0 && cowCount > 0) {
            strOut.append(" and ");
        }
        if (cowCount > 0) {
            strOut.append(String.format("%d cow(s)", cowCount));
        }

        if (bullCount == 0 && cowCount == 0) {
            strOut.append("None");
        }

        System.out.println(strOut.append(String.format(". The secret code is %s.", secretNumber)));
    }
}
