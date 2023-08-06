import java.util.Scanner;

class Time {
    int hour;
    int minute;
    int second;

    public static Time noon() {
        // write your code here;
        Time time = new Time();
        time.hour = 12;
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
        Time time = new Time();
        int tmp = (int) (seconds / 3600);
        time.hour = tmp > 23 ? (tmp % 24) : tmp;
        time.minute = (int) ((seconds % 3600) / 60);
        time.second = (int) (seconds % 60);
        return time;
        // write your code here;
    }

    public static Time of(int hour, int minute, int second) {
        // write your code here;
        Time time = new Time();
        time.hour = hour;
        time.minute = minute;
        time.second = second;
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

            if (time == null) {
                System.out.println(time);
            } else {
                System.out.printf("%s %s %s", time.hour, time. minute, time.second);
            }
        }
    }

}
