import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class OddEven {
    public static List<Integer> sort(List<Integer> numbers) {
        List<Integer> output = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        numbers.forEach(num -> {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        });

        even.sort(Comparator.reverseOrder());
        odd.sort(Integer::compareTo);

        output.addAll(odd);
        output.addAll(even);

        return output;
    }

    public static void sortOddEven(List<Integer> numbers) {
        numbers.sort(Comparator
                .comparingInt((ToIntFunction<Integer>) x -> (x % 2) == 0 ? 1 : -1)
                .thenComparingInt(x -> (x % 2) == 0 ? -x : x)
        );
    }
}
