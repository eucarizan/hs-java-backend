public class Date {
    public static String checkDate(String date) {
        String yearMonthDate = "(19\\d{2}|20\\d{2})[-/.](1[12]|0[1-9])[-/.](3[01]|[0-2][0-9])";
        String dateMonthYear = "(3[01]|[0-2][0-9])[-/.](1[12]|0[1-9])[-/.](19\\d{2}|20\\d{2})";

        return date.matches(yearMonthDate) | date.matches(dateMonthYear) ? "Yes" : "No";
    }
}
