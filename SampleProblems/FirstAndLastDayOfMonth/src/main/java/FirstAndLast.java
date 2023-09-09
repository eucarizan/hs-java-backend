import java.time.LocalDate;

public class FirstAndLast {
    public static String dayOfMonth(int year, int month) {
        month = month < 1 ? 1 : month > 12 ? 1 : month;
        LocalDate date = LocalDate.parse(String.format("%d-%02d-%02d", year, month, 1));
        return date + " " + date.plusDays(date.lengthOfMonth() - 1);
    }
}
