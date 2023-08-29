import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

public class TimeAndDate {
    public static int compareRange(LocalDateTime range1, LocalDateTime range2, List<LocalDateTime> dateTimes) {
        Predicate<LocalDateTime> dateFilter1 = date ->
                (date.isEqual(range1) || date.isAfter(range1)) && date.isBefore(range2);
        Predicate<LocalDateTime> dateFilter2 = date ->
                (date.isEqual(range2) || date.isAfter(range2)) && date.isBefore(range1);

        return Math.toIntExact(dateTimes.stream()
                .filter(dateFilter1.or(dateFilter2))
                .count());
    }
}
