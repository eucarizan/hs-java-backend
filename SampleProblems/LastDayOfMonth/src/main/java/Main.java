import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int year = scanner.nextInt();
            int days = scanner.nextInt();
            LocalDate date = LocalDate.ofYearDay(year, days);

            System.out.println(date.lengthOfMonth() == date.getDayOfMonth());

            System.out.println();
            System.out.println(date);
            System.out.printf("day (%d) of month (%s)%n",date.getDayOfMonth(), date.getMonth());
            System.out.printf("month (%s) has length of (%d)%n" , date.getMonth(), date.lengthOfMonth());


        }
    }
}
/*
sample cases:
2017 59
feb 28
 */