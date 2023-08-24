import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "Test{index}: sortOddAscEvenDesc({0}) == {1}")
    @CsvSource(value = {
            "0 1 2 3 4 5:1, 3, 5, 4, 2, 0",
            "5 4 7 2 1 4:1, 5, 7, 4, 4, 2"}, delimiter = ':')
    public void test(String input, String expected) {
        String[] inputs = input.split(" ");
        List<Integer> nums = new ArrayList<>();

        for (String s : inputs) {
            nums.add(Integer.parseInt(s));
        }

        nums = OddEven.sort(nums);

        assertEquals(expected, nums.toString().replaceAll("\\[", "").replaceAll("]", ""));
    }
}
