import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeClassTest {
    @Test
    @DisplayName("givenUnsortedArrayAndNumberToSearchWhenSortedDescAndSearchedThenFound")
    void test1() {
        int[] intArray = {3, 4, 9, 2, 1, 4, 5, 8, 3, 4, 0, 12};
        int expected = 1;

        assertEquals(expected, SortSearch.binaryFind(9, intArray));
    }

    @Test
    void test2() {
        int[] array = {80, 23, 65, 872, 24, 76, 24, 31, 256, 785, 12, 789};

        assertEquals(7, SortSearch.binaryFind(31, array));
    }
}
