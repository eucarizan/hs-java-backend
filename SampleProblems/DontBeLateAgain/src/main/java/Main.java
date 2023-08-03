import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            solution1(scanner);
            streamSolution(scanner);
        }
    }

    private static void streamSolution(Scanner scanner) {
        final int WAY_TO_SHOP = 30;
        final LocalTime HOUR_1930 = LocalTime.of(19, 30);
        final LocalTime SHOP_ARRIVAL_TIME = HOUR_1930.plusMinutes(WAY_TO_SHOP);

        scanner
                .useDelimiter("\n")
                .tokens()
                .skip(1)
                .map(str -> str.split("\\s+"))
                .filter(strings ->
                        LocalTime.parse(strings[1]).isAfter(SHOP_ARRIVAL_TIME))
                .map(strings -> strings[0])
                .forEachOrdered(System.out::println);
    }

    private static void solution1(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine();

        final int WAY_TO_SHOP = 30;
        final LocalTime HOUR_1930 = LocalTime.of(19, 30);
        final LocalTime SHOP_ARRIVAL_TIME = HOUR_1930.plusMinutes(WAY_TO_SHOP);

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String store = input[0];
            LocalTime time = LocalTime.parse(input[1]);

            if (time.isAfter(SHOP_ARRIVAL_TIME)) {
                System.out.println(store);
            }
        }
    }
}
