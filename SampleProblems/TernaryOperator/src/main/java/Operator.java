import java.util.function.Function;
import java.util.function.Predicate;

public class Operator {
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? super U> ifTrue,
            Function<? super T, ? super U> ifFalse
    ) {
        if (ifTrue == null) {
            return t -> (U) ifFalse.apply(t);
        }

        if (ifFalse == null) {
            return t -> (U) ifTrue.apply(t);
        }

        if (condition == null) {
            return t -> (U) ifFalse.apply(t);
        }

        return t -> condition.test(t) ? (U) ifTrue.apply(t) : (U) ifFalse.apply(t);
    }
}
