import java.util.List;
import java.util.TreeMap;

public class CreateMap {
    public static String createTreeMap(List<String> inputs) {
        TreeMap<String, Integer> map = new TreeMap<>();

        inputs.forEach(
                input -> {
                    String[] inputArr = input.split(" - ");
                    map.put(inputArr[0], Integer.parseInt(inputArr[1]));
                }
        );

        return map.toString();
    }
}
