import java.util.List;

public class Elements {
    public static int sum(List<Integer> nums, int limit, int value) {
        return nums.stream()
                .limit(Math.max(limit, 0))
                .filter(num -> num > value)
                .reduce(0, Integer::sum);
    }
}
