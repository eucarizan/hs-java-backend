import java.util.Collections;
import java.util.List;

public class Counter {
    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
//        return list1.stream().filter(n -> n == elem).count() == list2.stream().filter(n -> n == elem).count();
        return Collections.frequency(list1, elem) == Collections.frequency(list2, elem);
    }

}
