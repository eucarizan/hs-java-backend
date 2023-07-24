import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String[][] cinema;
    static int rows;
    static int seats;

    public static void main(String[] args) {
        int capacity = generateCinema();
        printCinema();
        getSeatNumber(capacity);
    }

    private static int generateCinema() {
        System.out.printf("Enter the number of rows:%n");
        rows = scanner.nextInt();
        System.out.printf("Enter the number of seats in each row:%n");
        seats = scanner.nextInt();
        cinema = new String[rows+1][seats+1];

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                cinema[i][j] = "  ";
            }
        }

        for (int i = 0, j = 1; j <= seats; j++) {
            cinema[i][j] = j + " ";
        }

        for (int i = 1, j = 0; i <= rows; i++) {
            cinema[i][j] = i + " ";
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= seats; j++) {
                cinema[i][j] = "S ";
            }
        }

        return rows * seats;
    }

    private static void printCinema() {
        System.out.println("\nCinema:");
        for (String[] strings : cinema) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static void getSeatNumber(int capacity) {
        System.out.printf("%nEnter a row number:%n");
        int row = scanner.nextInt();
        System.out.printf("Enter a seat number in that row:%n");
        int seat = scanner.nextInt();
        cinema[row][seat] = "B ";

        printTicketPrice(capacity, row, seat);
        printCinema();
    }

    private static void printTicketPrice(int capacity, int row, int seat) {
        int ticketPrice = 10;
//        int income;

//        if (capacity > 60) {
//            int firstHalf = rows/2;
//            int secondHalf = rows-firstHalf;
//            income = seats * ((firstHalf * ticketPrice) + (secondHalf  * 8));
//        } else {
//            income = capacity * ticketPrice;
//        }

        if (capacity > 60) {
            int firstHalf = rows/2;
            if (row > firstHalf) {
                ticketPrice = 8;
            }
        }

        System.out.printf("%nTicket price: $%d%n", ticketPrice);
    }
}
