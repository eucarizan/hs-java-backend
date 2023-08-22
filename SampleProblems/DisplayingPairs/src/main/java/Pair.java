import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pair {
    public static List<String> display(Map<String, Integer> map) {
        List<String> list = new ArrayList<>();

        map.forEach((key, value) -> list.add(key + "=" + value));

        return list;
    }

    public static void displayPrint(Map<String, Integer> map) {
        map.entrySet().forEach(System.out::println);
    }
}
