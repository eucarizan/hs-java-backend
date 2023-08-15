import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        try (Scanner scanner = new Scanner(System.in)) {
            BigDecimal num1 = scanner.nextBigDecimal();
            BigDecimal num2 = scanner.nextBigDecimal();
            BigDecimal num3 = scanner.nextBigDecimal();

            BigDecimal three = new BigDecimal("3");
            BigDecimal output = num1.add(num2).add(num3).divide(three, 0, RoundingMode.DOWN);
            System.out.println(output);
        }
    }
}