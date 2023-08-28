import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Stream.of(1, 2, 3, 4, 5).toList();

        a(numbers);
        b(numbers);
        c(numbers);
        d(numbers);
    }

    private static void a(List<Integer> numbers) {
        List<Integer> generated = numbers.stream()
                .flatMap(n -> Stream.generate(() -> n).limit(n))
                .toList();

        System.out.println(generated);
    }

    private static void b(List<Integer> numbers) {
        List<Integer> generated = numbers.stream()
                .flatMapToInt(n -> IntStream.rangeClosed(1, n))
                .boxed()
                .toList();

        System.out.println(generated);
    }

    private static void c(List<Integer> numbers) {
        List<Integer> generated = numbers.stream()
                .flatMapToInt(n -> IntStream.iterate(n, val -> val + 1).limit(n))
                .boxed()
                .toList();

        System.out.println(generated);
    }

    private static void d(List<Integer> numbers) {
        List<Integer> generated = numbers.stream()
                .flatMap(Stream::of)
                .toList();

        System.out.println(generated);
    }
}