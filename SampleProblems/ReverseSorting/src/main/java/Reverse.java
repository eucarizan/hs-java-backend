import java.util.Comparator;
import java.util.List;

public class Reverse {
    public static void sortStrings(List<String> list) {
        list.sort(Comparator.reverseOrder());
    }
}
