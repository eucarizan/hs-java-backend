import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

//        forLoop(num);
//        whileLoop(num);
        IntStream
                .range(1, num)
                .filter(n -> n*n <= num)
                .map(n -> n*n)
                .forEach(System.out::println);

    }

    private static void whileLoop(int num) {
        int counter = 1;
        int squaredNum = 1;

        while (squaredNum <= num) {
            System.out.println(squaredNum);
//            counter++;
            squaredNum=++counter*counter;
        }
    }

    private static void forLoop(int num) {
        for (int i = 1; i * i <= num; i++) {
            System.out.println(i*i);
        }
    }
}
