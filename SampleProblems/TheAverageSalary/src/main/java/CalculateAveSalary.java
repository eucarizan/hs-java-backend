import java.util.Collection;
import java.util.stream.Collectors;

public class CalculateAveSalary {
    public static double calcAverageSalary(Collection<Integer> salaries) {
        if (salaries.isEmpty()) {
            return 0.0;
        }

//        return salaries.stream().mapToDouble(i -> i).sum() / salaries.size();
        return salaries.stream().collect(Collectors.averagingDouble(Integer::doubleValue));
    }
}
