import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5));
        OddEven.sortOddEven(nums);
        System.out.println(nums);
    }
}