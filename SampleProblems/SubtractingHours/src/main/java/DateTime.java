import java.time.LocalDateTime;

public class DateTime {
    public static String minusHoursPlusMinutes(String dateTimeStr, int hours, int min) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) {
            return "";
        }

        if (!dateTimeStr.matches("\\d+-\\d{2}-\\d{2}T\\d{2}:\\d{2}(:\\d{2})?(.\\d+)?")) {
            return "";
        }

        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr);
        return dateTime.minusHours(hours).plusMinutes(min).toString();
    }
}
