import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int year = scanner.nextInt();
            int days = scanner.nextInt();
            final int daysMinusOne = days - 1;
            final int january = 1;
            final int dayOne = 1;

            LocalDate monthStart = LocalDate.of(year, january, dayOne).plusDays(daysMinusOne);

            System.out.println(monthStart.lengthOfMonth() == monthStart.getDayOfMonth());

            System.out.println();
            System.out.println(monthStart);
            System.out.println("date " + monthStart.getDayOfMonth());
            System.out.println("date check: " + monthStart.getMonth() + " " + monthStart.lengthOfMonth());
            LocalDate monthEnd = monthStart.plusDays(monthStart.lengthOfMonth()-1);


        }
    }
}
