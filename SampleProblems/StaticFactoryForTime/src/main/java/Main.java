import java.util.Scanner;

class Time {
    int hour;
    int minute;
    int second;

    public static Time noon() {
        // write your code here;
    }

    public static Time midnight() {
        // write your code here;
    }

    public static Time ofSecond(long seconds) {
        // write your code here;
    }

    public static Time of(int hour, int minute, int second) {
        // write your code here;
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
