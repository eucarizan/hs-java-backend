import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(8, 8, 3, 3, 2);
        List<Integer> list2 = List.of(1, 3, 3, 2);
        List<Integer> list3 = List.of(9, 8, 4, 3, 2);
        List<Integer> list4 = List.of(1, 3, 3, 3);
        System.out.println(Counter.checkTheSameNumberOfTimes(3, list1, list2));
        System.out.println(Counter.checkTheSameNumberOfTimes(3, list3, list4));
    }
}
