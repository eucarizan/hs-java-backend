import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinMax {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super  T, ? super T> minMaxConsumer
    ) {

        List<? extends T> list = stream.toList();
        minMaxConsumer.accept(list.stream().min(order).orElse(null), list.stream().max(order).orElse(null));
    }

    public static <T> void findMinMaxNJ(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super  T, ? super T> minMaxConsumer
    ) {
        ArrayDeque<T> arrayDeque = stream.sorted(order).collect(Collectors.toCollection(ArrayDeque::new));

        if (arrayDeque.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            T min = arrayDeque.getFirst();
            T max = arrayDeque.getLast();
            minMaxConsumer.accept(min, max);
        }
    }
}
