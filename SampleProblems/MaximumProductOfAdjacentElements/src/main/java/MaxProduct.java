import java.util.stream.IntStream;

public class MaxProduct {
    public static long select(int[] nums) {
        long max = 0;

        for (int i = 0; i + 1 < nums.length; i++) {
            max = Math.max(max, (long) nums[i] * nums[i + 1]);
        }

        return max;
    }

    public static long selectStream(int[] nums) {
        return IntStream.range(0, nums.length - 1)
                .map(i -> nums[i] * nums[i + 1])
                .max()
                .orElse(0);
    }
}
