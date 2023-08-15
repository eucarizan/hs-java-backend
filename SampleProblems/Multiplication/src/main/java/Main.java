import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        try (Scanner scanner = new Scanner(System.in)) {
            BigDecimal multiplicand = scanner.nextBigDecimal();
            BigDecimal multiplier = scanner.nextBigDecimal();
            System.out.println(multiplicand.multiply(multiplier));
        }
    }
}