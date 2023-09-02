import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> list = new Stack<>();

        IntStream.range(0, 4)
                .forEach(i -> list.push(scanner.next()));

        for (int i = 0; i < 4; i++) {
            System.out.println(list.pop());
        }
    }
}