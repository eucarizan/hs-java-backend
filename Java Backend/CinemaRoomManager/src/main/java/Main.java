import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cinema = """
                Cinema:
                  1 2 3 4 5 6 7 8
                1 S S S S S S S S
                2 S S S S S S S S
                3 S S S S S S S S
                4 S S S S S S S S
                5 S S S S S S S S
                6 S S S S S S S S
                7 S S S S S S S S
                """;

//        System.out.println(cinema);
        System.out.printf("Enter the number of rows:%n> ");
        int rows = scanner.nextInt();
        System.out.printf("Enter the number of seats in each row:%n> ");
        int seats = scanner.nextInt();
        int capacity = rows * seats;

        int ticketPrice = 10;
        int income = 0;
        if (capacity > 60) {
            int firstHalf = rows/2;
            int secondHalf = rows-firstHalf;
            income = seats * ((firstHalf * ticketPrice) + (secondHalf  * 8));
        } else {
            income = capacity * ticketPrice;
        }
        System.out.printf("Total income: %n$%d", income);
    }
}
