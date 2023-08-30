//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class SomeParamTest {
//
//    @ParameterizedTest(name = "{index} {0} {1}")
//    @CsvSource({"1, 2", "3, 4"})
//    public void test() {
//        assertEquals(expected, result);
//    }
//}

/*

1. **Generate 0 Cats:**
   Input: `n = 0`
   Expected Output: `[]`

2. **Generate 1 Cat:**
   Input: `n = 1`
   Expected Output: `[Cat(name=null, age=0)]`

3. **Generate 5 Cats:**
   Input: `n = 5`
   Expected Output: `[Cat(name=null, age=0), Cat(name=null, age=0), Cat(name=null, age=0), Cat(name=null, age=0), Cat(name=null, age=0)]`

4. **Generate Large Number of Cats:**
   Input: `n = 1000`
   Expected Output: A list containing 1000 `Cat` instances with default values.

5. **Generate Negative Number of Cats:**
   Input: `n = -1`
   Expected Output: IllegalArgumentException or similar exception, indicating that the number of cats must be non-negative.

6. **Generate Max Value Number of Cats:**
   Input: `n = Integer.MAX_VALUE`
   Expected Output: The method might run into memory constraints due to attempting to generate such a large number of instances.

7. **Generate Cats and Check Properties:**
   Input: `n = 3`
   Expected Output: A list containing three `Cat` instances with default values. You can check that all cats have null names and ages of 0.

8. **Generate Cats with Set Properties:**
   Input: `n = 2`, Modify the `Cat` constructor to set the name and age.
   Expected Output: A list containing two `Cat` instances with the set name and age.

9. **Generate Cats and Check for Equality:**
   Input: `n = 3`
   Expected Output: Compare instances within the generated list to ensure they are distinct objects (not references to the same object).

10. **Generate a Mix of Cats and Nulls:**
    Input: `n = 4`, Intersperse `null` values among the generated cats.
    Expected Output: A list containing four elements, some of which are `Cat` instances and some of which are `null`.

 */