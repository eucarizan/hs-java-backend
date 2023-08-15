import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        try (Scanner scanner = new Scanner(System.in)) {
            BigDecimal dwalin = scanner.nextBigDecimal();
            BigDecimal balin = scanner.nextBigDecimal();
            BigDecimal thorin = scanner.nextBigDecimal();

            System.out.println(dwalin.add(balin).add(thorin));
        }
    }
}