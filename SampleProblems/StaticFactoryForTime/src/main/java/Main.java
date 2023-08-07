import java.util.Scanner;
import java.util.function.Predicate;

class Time {
    int hour;
    int minute;
    int second;
    static final int ONE_DAY = 24;
    static final Predicate<Integer> VALID_HOUR = s -> s >= 0 && s < ONE_DAY;
    static final int SIXTY = 60;

    public static Time noon() {
        // write your code here;
        final int twelve = 12;
        Time time = new Time();
        time.hour = twelve;
        time.minute = 0;
        time.second = 0;
        return time;
    }

    public static Time midnight() {
        // write your code here;
        Time time = new Time();
        time.hour = 0;
        time.minute = 0;
        time.second = 0;
        return time;
    }

    public static Time ofSecond(long seconds) {
        final int secondsToHour = 3600;

        Time time = new Time();
        int tmp = (int) (seconds / secondsToHour);
        time.hour = VALID_HOUR.test(tmp) ? tmp : (tmp % ONE_DAY);
        time.minute = (int) ((seconds % secondsToHour) / SIXTY);
        time.second = (int) (seconds % SIXTY);
        return time;
        // write your code here;
    }

    public static Time of(int hour, int minute, int second) {
        // write your code here;
        Predicate<Integer> validTime = t -> t >= 0 && t < SIXTY;
        Time time = new Time();

        if (VALID_HOUR.negate().test(hour) || validTime.negate().test(minute) || validTime.negate().test(second)) {
            return null;
        }

        time.second = second;
        time.minute = minute;
        time.hour = hour;
        return time;
    }
}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final String type = scanner.next();

            Time time = switch (type) {
                case "noon" -> Time.noon();
                case "midnight" -> Time.midnight();
                case "hms" -> {
                    int h = scanner.nextInt();
                    int m = scanner.nextInt();
                    int s = scanner.nextInt();
                    yield Time.of(h, m, s);
                }
                case "seconds" -> Time.ofSecond(scanner.nextInt());
                default -> null;
            };

            if (time != null) {
                System.out.printf("%s %s %s", time.hour, time.minute, time.second);
            } else {
                System.out.println((Object) null);
            }
        }
    }
}