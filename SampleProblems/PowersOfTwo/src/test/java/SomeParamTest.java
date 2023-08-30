import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "{index} powerOfTwo({0}) == {1}")
    @CsvSource(value = {
            "3 : [1, 2, 4]",
            "1 : [1]",
            "4 : [1, 2, 4, 8]"
    }, delimiter = ':')
    public void test(int n, String expected) {
        assertEquals(expected, PowerOfTwo.generate(n).toList().toString());
    }
}

/*
    TDD

    @Test
    public void testGenerateSequence() {
        Stream<Integer> generatedStream = YourTestClass.generate(5);

        List<Integer> generatedList = generatedStream.collect(Collectors.toList());

        assertEquals(Arrays.asList(1, 2, 4, 8, 16), generatedList);
    }

    // write code to handle test

    // add test

    @Test
    public void testGenerateZeroInput() {
        Stream<Integer> generatedStream = YourTestClass.generate(0);

        List<Integer> generatedList = generatedStream.collect(Collectors.toList());

        assertTrue(generatedList.isEmpty(), "Generated list should be empty for zero input");
    }

    @Test
    public void testGenerateNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> YourTestClass.generate(-5));
    }

    @Test
    public void testGenerateLargerInput() {
        Stream<Integer> generatedStream = YourTestClass.generate(10);

        List<Integer> generatedList = generatedStream.collect(Collectors.toList());

        assertEquals(Arrays.asList(1, 2, 4, 8, 16, 32, 64, 128, 256, 512), generatedList);
    }

    @Test
    public void testGenerateSingleValue() {
        Stream<Integer> generatedStream = YourTestClass.generate(1);

        List<Integer> generatedList = generatedStream.collect(Collectors.toList());

        assertEquals(Collections.singletonList(1), generatedList);
    }

    @Test
    public void testGenerateLargeInput() {
        int n = 1000000; // Large input value

        Stream<Integer> generatedStream = YourTestClass.generate(n);

        // Test the first few values
        assertEquals(1, generatedStream.findFirst().orElse(0));
        assertEquals(2, generatedStream.skip(1).findFirst().orElse(0));
        assertEquals(4, generatedStream.skip(2).findFirst().orElse(0));

        // Verify that the stream ends as expected
        assertFalse(generatedStream.anyMatch(x -> true));
    }



 */
/*

1. **Generate 0 Integers:**
   Input: `n = 0`
   Expected Output: An empty stream

2. **Generate 1 Integer:**
   Input: `n = 1`
   Expected Output: A stream containing `[1]` (2^0 = 1)

3. **Generate 5 Integers:**
   Input: `n = 5`
   Expected Output: A stream containing `[1, 2, 4, 8, 16]` (2^0, 2^1, 2^2, 2^3, 2^4)

4. **Generate Negative Number of Integers:**
   Input: `n = -1`
   Expected Output: IllegalArgumentException or similar exception, indicating that the number of integers must be non-negative.

5. **Generate Max Value Number of Integers:**
   Input: `n = Integer.MAX_VALUE`
   Expected Output: The stream might be too large to handle due to memory and processing constraints.

6. **Generate Integers and Check Properties:**
   Input: `n = 4`
   Expected Output: A stream containing the first four powers of 2: `[1, 2, 4, 8]`.

7. **Generate Integers and Verify Ordering:**
   Input: `n = 5`
   Expected Output: A stream containing the first five powers of 2: `[1, 2, 4, 8, 16]`. Check that the ordering is maintained.

8. **Generate Integers with Large Exponents:**
   Input: `n = 3`
   Expected Output: A stream containing `[1, 2, 4]` (2^0, 2^1, 2^2).

9. **Generate Integers and Check for Overflow:**
   Input: `n = 10`
   Expected Output: Ensure that the generated integers do not overflow the bounds of the `Integer` type.

10. **Generate Integers and Check for Equality:**
    Input: `n = 4`
    Expected Output: Verify that the integers within the stream are distinct values.

 */
