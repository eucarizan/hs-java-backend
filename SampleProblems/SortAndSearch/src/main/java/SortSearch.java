import java.util.Arrays;
import java.util.Collections;

public class SortSearch {
    public static int binaryFind(int num, int[] numbers) {
        numbers = Arrays.stream(numbers)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int low = 0;
        int high = numbers.length;

        do {
            int mid = low + (high - low) / 2;
            int midNumber = numbers[mid];
            if (num == midNumber) {
                return mid;
            } else if (num > midNumber) {
                high = mid;
            } else {
                low = mid + 1;
            }
        } while (low < high);

        return -1;
    }
}
