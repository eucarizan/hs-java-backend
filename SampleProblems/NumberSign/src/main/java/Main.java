import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(sign(n));
    }

    private static int sign(int number) {
//        return Integer.compare(number, 0);
        return number == 0 ? 0 : number / Math.abs(number);
    }

}
