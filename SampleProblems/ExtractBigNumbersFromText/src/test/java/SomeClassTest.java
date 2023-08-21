import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeClassTest {
    @Test
    void test() {
        String text = "If X is 609348676234, Y is 3077, the sum is 609348679311.";
        List<String> expected = List.of("609348676234:12", "609348679311:12");

        assertEquals(expected, BigNum.searchText(text));
    }
}
