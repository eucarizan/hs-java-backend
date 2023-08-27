import java.util.stream.LongStream;

public class PrimeNumbers {
    public static boolean isPrime(long number) {
        return LongStream.rangeClosed(2, number / 2)
                .noneMatch(i -> number % i == 0);
    }
}
