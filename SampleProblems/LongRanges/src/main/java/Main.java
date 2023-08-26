import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        boolean result = !IntStream
                .generate(() -> 100)
                .limit(101)
                .allMatch(val -> val >= 100);

        System.out.println(result);
    }
}