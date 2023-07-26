import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfParts = scanner.nextInt();
        int toFix = 0;
        int rejects = 0;
        int toShip = 0;

        for (int i = 0; i < numOfParts; i++) {
            int num = scanner.nextInt();
            switch (num) {
                case 0 -> toShip++;
                case 1 -> toFix++;
                case -1 -> rejects++;
            }
        }

        System.out.printf("%d %d %d", toShip, toFix, rejects);
    }
}
