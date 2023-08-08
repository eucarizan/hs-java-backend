import java.util.Arrays;
import java.util.Scanner;

class Finder {

    private final FindingStrategy strategy;

    public Finder(FindingStrategy strategy) {
        // write your code here
        this.strategy = strategy;
    }

    /**
     * It performs the search algorithm according to the given strategy
     */
    public int find(int[] numbers) {
        // write your code here
        return this.strategy.getResult(numbers);
    }
}

interface FindingStrategy {

    /**
     * Returns search result
     */
    int getResult(int[] numbers);

}

class MaxFindingStrategy implements FindingStrategy {
    @Override
    public int getResult(int[] numbers) {
        // write your code here
        return Arrays.stream(numbers)
                .max()
                .orElse(Integer.MIN_VALUE);
    }
}

class MinFindingStrategy implements FindingStrategy {
    @Override
    public int getResult(int[] numbers) {
        // write your code here
        return Arrays
                .stream(numbers)
                .min()
                .orElse(Integer.MAX_VALUE);
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {    
            final String[] elements = scanner.nextLine().split("\\s+");
            int[] numbers = null;
    
            if ("EMPTY".equals(elements[0])) {
                numbers = new int[0];
            } else {
                numbers = new int[elements.length];
                for (int i = 0; i < elements.length; i++) {
                    numbers[i] = Integer.parseInt(elements[i]);
                }
            }
    
            final String type = scanner.nextLine();
    
            Finder finder = null;
    
            switch (type) {
                case "MIN" -> finder = new Finder(new MinFindingStrategy());
                case "MAX" -> finder = new Finder(new MaxFindingStrategy());
                default -> {
                }
            }
    
            if (finder == null) {
                throw new RuntimeException(
                        "Unknown strategy type passed. Please, write to the author of the problem.");
            }
    
            System.out.println(finder.find(numbers));
        }
    }
}