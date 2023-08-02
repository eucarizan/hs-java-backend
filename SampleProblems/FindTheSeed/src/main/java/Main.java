import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int startSeed = scanner.nextInt();
            int lastSeed = scanner.nextInt();
            int n = scanner.nextInt();
            int range = scanner.nextInt();

            int seed = 0;
            int num = range;

            for (int i = startSeed; i <= lastSeed; i++) {
                Random random = new Random(i);
                int maxNum = 0;

                for (int j = 0; j < n; j++) {
                    int randomNumber = random.nextInt(0, range);

                    if (randomNumber > maxNum) {
                        maxNum = randomNumber;
                    }
                }

                if (maxNum < num) {
                    num = maxNum;
                    seed = i;
                }
            }
            System.out.println(seed + "\n" + num);
        }
    }
}
