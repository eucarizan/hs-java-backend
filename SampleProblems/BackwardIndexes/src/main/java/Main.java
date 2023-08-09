import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static <T> T getElementByIndex(List<T> lst, int index) {
        // write your code here
        final int reverseIdx = lst.size() * -1;

        if (index >= 0 && index < lst.size()) {
            return lst.get(index);
        } else if (index < 0 && index >= reverseIdx) {
            return lst.get(lst.size() + index);
        }

        throw new IndexOutOfBoundsException();
    }

    /* Do not change code below */
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final List<String> values = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        final int index = Integer.parseInt(scanner.nextLine());

        try {
            String element = getElementByIndex(values, index);
            System.out.println(element);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception");
        }
    }
}