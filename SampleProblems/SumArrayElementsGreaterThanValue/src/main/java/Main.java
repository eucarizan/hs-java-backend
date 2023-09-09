import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int end = Integer.parseInt(scanner.nextLine());

            Stream<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                    .limit(end)
                    .map(Integer::parseInt);

            int n = Integer.parseInt(scanner.nextLine());

            System.out.println(nums.filter(num -> num > n).reduce(0, Integer::sum));
        }
    }
}