import java.util.Arrays;
import java.util.List;

public class Enums {
    public static List<String> daysOfWeek() {
        return Arrays.stream(DaysOfWeek.values()).map(String::valueOf).toList();
    }
}

