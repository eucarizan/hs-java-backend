import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} method({1}) == {2}")
    @CsvSource(value = {
            "testSample : dep-1, 111-1, William, 20000; dep-1, 111-1, Sophia, 10000; dep-2, 222-1, John, 50000 : 20000 : 1"
    }, delimiter = ':')
    public void test(String testName, String input, long threshold, long expected) {
        String[] param = input.split("; ");
        List<Department> departments = new ArrayList<>();

        String[] part1 = param[0].split(", ");
        String[] part2 = param[1].split(", ");
        String[] part3 = param[2].split(", ");

        Employee employee1 = new Employee(part1[2], Long.parseLong(part1[3]));
        Employee employee2 = new Employee(part2[2], Long.parseLong(part2[3]));
        Department department1 = new Department(part1[0], part1[1], new ArrayList<>());
        department1.getEmployees().add(employee1);
        department1.getEmployees().add(employee2);

        Employee employee3 = new Employee(part3[2], Long.parseLong(part3[3]));
        Department department2 = new Department(part3[0], part3[1], new ArrayList<>());
        department2.getEmployees().add(employee3);

        departments.add(department1);
        departments.add(department2);

        long result = EmployeesCounter.calcNumberOfEmployees(departments, threshold);

        assertEquals(expected, result);
    }

    @Test
    public void testCalcNumberOfEmployeesWithEmptyDepartments() {
        List<Department> departments = new ArrayList<>();
        long threshold = 20000;
        long expectedCount = 0;

        long actualCount = EmployeesCounter.calcNumberOfEmployees(departments, threshold);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testCalcNumberOfEmployeesWithNoMatchingEmployees() {
        List<Department> departments = Arrays.asList(
                new Department("dep-1", "111-2", List.of(
                        new Employee("Sophia", 10000L)
                )),
                new Department("dep-2", "222-1", List.of(
                        new Employee("John", 50000L)
                ))
        );
        long threshold = 20000;
        long expectedCount = 0;

        long actualCount = EmployeesCounter.calcNumberOfEmployees(departments, threshold);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testCalcNumberOfEmployeesWithThresholdZero() {
        List<Department> departments = Arrays.asList(
                new Department("dep-1", "111-1", Arrays.asList(
                        new Employee("William", 20000L),
                        new Employee("Sophia", 10000L)
                )),
                new Department("dep-2", "222-1", List.of(
                        new Employee("John", 50000L)
                ))
        );
        long threshold = 0;
        long expectedCount = 2;

        long actualCount = EmployeesCounter.calcNumberOfEmployees(departments, threshold);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testCalcNumberOfEmployeesWithNullDepartments() {
        List<Department> departments = null;
        long threshold = 20000;
        long expectedCount = 0;

        long actualCount = EmployeesCounter.calcNumberOfEmployees(departments, threshold);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testCalcNumberOfEmployeesWithNoMatchingDepartments() {
        List<Department> departments = Arrays.asList(
                new Department("dep-3", "333-1", List.of(
                        new Employee("Grace", 25000L)
                )),
                new Department("dep-4", "444-1", List.of(
                        new Employee("Oliver", 30000L)
                ))
        );
        long threshold = 20000;
        long expectedCount = 0;

        long actualCount = EmployeesCounter.calcNumberOfEmployees(departments, threshold);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testCalcNumberOfEmployeesWithMatchingDepartmentsButNoMatchingEmployees() {
        List<Department> departments = Arrays.asList(
                new Department("dep-1", "111-1", Arrays.asList(
                        new Employee("William", 20000L),
                        new Employee("Sophia", 10000L)
                )),
                new Department("dep-2", "111-2", Collections.emptyList())
        );
        long threshold = 30000;
        long expectedCount = 0;

        long actualCount = EmployeesCounter.calcNumberOfEmployees(departments, threshold);

        assertEquals(expectedCount, actualCount);
    }
}
