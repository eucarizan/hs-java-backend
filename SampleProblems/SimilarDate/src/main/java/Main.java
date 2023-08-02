import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        task1();
        System.out.println();
        task2();
    }

    private static void task2() {
        print(LocalDate.of(2018, 1, 1).withDayOfMonth(1));
        print(LocalDate.of(2018, 3, 2).minusMonths(2));
        print(LocalDate.of(2018, 2, 1));
        print(LocalDate.of(2018, 1, 1).plusDays(1));
        print(LocalDate.ofYearDay(2018, 2));

    }

    private static void task1() {
        print(LocalDate.parse("2018-01-12").minusMonths(2).minusDays(1));
        print(LocalDate.parse("2016-11-01").plusYears(1).plusDays(10));
        print(LocalDate.parse("2018-01-10").minusMonths(2).withDayOfMonth(1));
        print(LocalDate.parse("2017-01-01").withMonth(11).withDayOfMonth(11));
        print(LocalDate.parse("2017-11-12").minusMonths(1));
    }

    static void print(LocalDate date) {
        System.out.println(date);
    }


}
