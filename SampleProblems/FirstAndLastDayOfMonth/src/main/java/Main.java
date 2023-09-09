import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.parse(String.format("%d-%02d-%02d", 2017, 1, 1));
        System.out.println(date);
        System.out.println(date.plusDays(date.lengthOfMonth() - 1));
    }
}