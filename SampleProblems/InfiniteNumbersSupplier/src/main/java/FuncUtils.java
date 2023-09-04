import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class FuncUtils {
    public static Supplier<Integer> getInfiniteRangeAtomic() {
        AtomicInteger num = new AtomicInteger();
        return num::getAndIncrement;
    }

    public static Supplier<Integer> getInfiniteRange() {
        return new Supplier<>() {
            int num = 0;

            @Override
            public Integer get() {
                return num++;
            }
        };
    }
}
