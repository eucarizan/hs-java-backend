import java.util.Map;
import java.util.TreeMap;

public class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        if (map.isEmpty()) {
            return Map.of();
        }

        if (map.firstKey() % 2 != 0) {
            return map.descendingMap().subMap(5, 0);
        }

        return map.descendingMap().subMap(map.lastKey(), map.lastKey() - 5);
    }
}
