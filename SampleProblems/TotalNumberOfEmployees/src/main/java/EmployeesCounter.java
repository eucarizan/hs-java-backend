import java.util.List;

public class EmployeesCounter {
    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        if (departments == null) {
            return 0;
        }

        return departments.stream()
                .filter(dept -> dept.getCode().contains("111-"))
                .flatMap(dept -> dept.getEmployees().stream())
                .filter(employee -> employee.getSalary() >= threshold)
                .count();
    }
}
