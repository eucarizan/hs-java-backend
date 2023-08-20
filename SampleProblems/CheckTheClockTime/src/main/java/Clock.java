public class Clock {
    public static String checkTime(String time) {
        String regex = "(([01][0-9])|(2[0-3])):([0-5][0-9])";

        return time.matches(regex) ? "YES" : "NO";
    }
}
