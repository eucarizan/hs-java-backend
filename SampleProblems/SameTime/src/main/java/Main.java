import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        print(LocalTime.of(22, 30, 15).minusMinutes(20));
        print(LocalTime.of(22, 5).plusMinutes(15));

        print(LocalTime.of(22, 20).withSecond(15));
        print(LocalTime.of(22, 30).plusSeconds(15).withMinute(20));
        print(LocalTime.of(21, 0, 15).plusMinutes(80));
        System.out.println();
        print(LocalTime.of(1, 30).plusMinutes(690).getHour());
    }

    private static void print(LocalTime time) {
        System.out.println(time);
    }

    private static void print(int time) {
        System.out.println(time);
    }
}
