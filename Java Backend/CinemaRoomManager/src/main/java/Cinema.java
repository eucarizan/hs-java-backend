import java.util.Scanner;

public class Cinema {
    static Scanner scanner = new Scanner(System.in);
    static String[][] cinema;
    static int rows;
    static int seats;
    static int capacity;
    static int ticketsBought;
    static int totalIncome;
    static int currentIncome;

    static final int MAX_CAPACITY = 60;

    public static void main(String[] args) {
        generateCinema();

        int choice = getChoice();

        while (choice != 0) {
            switch (choice) {
                case 1 -> printCinema();
                case 2 -> buyTicket();
                case 3 -> getStatistics();
            }
            choice = getChoice();
        }
    }

    private static void generateCinema() {
        System.out.printf("Enter the number of rows:%n");
        rows = scanner.nextInt();
        System.out.printf("Enter the number of seats in each row:%n");
        seats = scanner.nextInt();
        capacity = seats * rows;
        cinema = new String[rows+1][seats+1];

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                cinema[i][j] = "S ";
            }
        }

        fillBorder();
        getTotalIncome();
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

    private static void buyTicket() {
        boolean seatChosen = false;
        int row = 0, seat = 0;

        while(!seatChosen) {
            System.out.printf("%nEnter a row number:%n");
            row = scanner.nextInt();
            System.out.printf("Enter a seat number in that row:%n");
            seat = scanner.nextInt();

            seatChosen = checkSeat(row, seat);
        }

        cinema[row][seat] = "B ";
        ticketsBought++;

        printTicketPrice(row, seat);
    }

    private static boolean checkSeat(int row, int seat) {
        boolean isInbound = row > 0 && row <= rows && seat > 0 && seat <= seats;

        if (!isInbound) {
            System.out.println("\nWrong input!");
            return false;
        }

        boolean isSeatTaken = cinema[row][seat].contains("B");

        if (isSeatTaken) {
            System.out.println("\nThat ticket has already been purchased!");
        }

        return !isSeatTaken;
    }

    private static void printTicketPrice(int row, int seat) {
        int ticketPrice = 10;

        if (capacity > MAX_CAPACITY) {
            int firstHalf = rows/2;
            if (row > firstHalf) {
                ticketPrice = 8;
            }
        }

        currentIncome+=ticketPrice;

        System.out.printf("%nTicket price: $%d%n", ticketPrice);
    }

    private static void fillBorder() {
        cinema[0][0] = "  ";

        for (int i = 0, j = 1; j <= seats; j++) {
            cinema[i][j] = j + " ";
        }

        for (int i = 1, j = 0; i <= rows; i++) {
            cinema[i][j] = i + " ";
        }
    }

    private static int getChoice() {
        System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
        return scanner.nextInt();
    }

    private static void getStatistics() {
//        double divisor = ticketsBought == 0 ? 1.0 : ticketsBought;
        System.out.printf("%nNumber of purchased tickets: %d%n" +
                "Percentage: %.2f%%%n" +
                "Current income: $%d%n" +
                "Total income: $%d%n",
                ticketsBought, (ticketsBought * 100.0 / capacity), currentIncome, totalIncome);
    }

    private static void getTotalIncome() {
        if (capacity > MAX_CAPACITY) {
            int firstHalf = rows/2;
            int secondHalf = rows - firstHalf;
            totalIncome += firstHalf * seats * 10;
            totalIncome += secondHalf * seats * 8;
        } else {
            totalIncome += capacity * 10;
        }
    }
}
