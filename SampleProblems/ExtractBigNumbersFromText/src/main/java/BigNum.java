import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BigNum {
    public static List<String> searchText(String text) {
        List<String> nums = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d{10,}");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String num = matcher.group();
            nums.add(num + ":" + num.length());
        }

        return nums;
    }
}
