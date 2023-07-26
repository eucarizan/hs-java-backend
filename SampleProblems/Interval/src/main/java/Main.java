import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        final int negativeFifteen = -15;
        final int twelve = 12;
        final int fourteen = 14;
        final int seventeen = 17;
        final int nineteen = 19;

        boolean first = num > negativeFifteen && num <= twelve;
        boolean second = num > fourteen && num < seventeen;
        boolean third = num >= nineteen;

        if (first || second || third) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
