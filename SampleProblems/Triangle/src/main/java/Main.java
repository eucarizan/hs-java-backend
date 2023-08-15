import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int side1 = scanner.nextInt();
            int side2 = scanner.nextInt();
            int side3 = scanner.nextInt();

            boolean valid = side1 < side2 + side3 && side2 < side1 + side3 && side3 < side1 + side2;
            if (valid) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}