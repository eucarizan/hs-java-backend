import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();

            switch (input) {
                case "triangle" -> {
                    double a = Double.parseDouble(scanner.nextLine());
                    double b = Double.parseDouble(scanner.nextLine());
                    double c = Double.parseDouble(scanner.nextLine());
                    double s = (a + b + c) / 2;
                    System.out.println(Math.sqrt(s * (s - a) * (s - b) * (s - c)));
                }
                case "rectangle" -> {
                    double length = Double.parseDouble(scanner.nextLine());
                    double width = Double.parseDouble(scanner.nextLine());
                    System.out.println(length * width);
                }
                case "circle" -> {
                    double r = Double.parseDouble(scanner.nextLine());
                    System.out.println(3.14 * r * r);
                }
            }
        }
    }
}
