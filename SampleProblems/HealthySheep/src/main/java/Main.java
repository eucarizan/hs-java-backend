import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int minSleep = scanner.nextInt();
            int maxSleep = scanner.nextInt();
            int sleep = scanner.nextInt();

            if (sleep >= minSleep) {
                if (sleep > maxSleep) {
                    System.out.println("Excess");
                } else {
                    System.out.println("Normal");
                }
            } else {
                System.out.println("Deficiency");
            }
        }
    }
}
