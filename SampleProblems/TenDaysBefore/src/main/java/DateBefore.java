import java.time.LocalDate;

public class DateBefore {
    public static LocalDate changeDate(String date) {
        if (date.isEmpty()) {
            return LocalDate.MIN;
        }
        return LocalDate.parse(date).minusDays(10);
    }
}
