public class Main {
    public static void main(String[] args) {
        Clock clock1 = new Clock();
        clock1.next();
        System.out.println(clock1.hours + ":" + String.format("%02d", clock1.minutes));

        Clock clock2 = new Clock();
        clock2.hours = 10;
        clock2.minutes = 59;
        clock2.next();
        System.out.println(clock2.hours + ":" + String.format("%02d", clock2.minutes));
    }
}

class Clock {
    public int hours;
    public int minutes;

    public Clock() {
        hours = 12;
        minutes = 0;
    }

    public void next() {
        if (minutes == 59) {
            if (hours == 12) {
                hours = 0;
            } else {
                hours++;
            }
            minutes = 0;
        } else {
            minutes++;
        }
    }
}
