import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final long number= scanner.nextInt();
        System.out.println(isComposite(number));
    }

    private static boolean isComposite(long number) {
        for (long i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }
}
