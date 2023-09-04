import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} method({1}) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testSample : 1, 2, 3, 4, 5, 6, 7, 8 : [4, 8, 2]"
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        String[] param = input.split(", ");
        Stream<Long> stream = Arrays.stream(param).map(Long::parseLong);
        Supplier<Stream<Long>> saved = FunctionUtils.saveStream(stream.filter(e -> e % 2 == 0));
        List<Long> result = new ArrayList<>();
        result.add(saved.get().count());
        result.add(saved.get().max(Long::compareTo).get());
        result.add(saved.get().min(Long::compareTo).get());

        assertEquals(expected, result.toString());
    }

    @Test
    public void testSaveStream() {
        // Create a sample stream of integers.
        Stream<Integer> originalStream = Stream.of(1, 2, 3, 4, 5);

        // Save the original stream using the saveStream method.
        Supplier<Stream<Integer>> supplier = FunctionUtils.saveStream(originalStream);

        // Collect the saved stream into a list.
        List<Integer> savedList = supplier.get().collect(Collectors.toList());

        // Verify that the saved stream matches the original stream.
        assertEquals(List.of(1, 2, 3, 4, 5), savedList);
    }

    @Test
    public void testSaveStreamWithStrings() {
        // Create a sample stream of strings.
        Stream<String> originalStream = Stream.of("apple", "banana", "cherry", "date");

        // Save the original stream using the saveStream method.
        Supplier<Stream<String>> supplier = FunctionUtils.saveStream(originalStream);

        // Collect the saved stream into a list.
        List<String> savedList = supplier.get().collect(Collectors.toList());

        // Verify that the saved stream matches the original stream.
        assertEquals(List.of("apple", "banana", "cherry", "date"), savedList);
    }

    @Test
    public void testSaveStreamWithEmptyStream() {
        // Create an empty stream of integers.
        Stream<Integer> stream = Stream.empty();

        // Save the empty stream using saveStream.
        Supplier<Stream<Integer>> saved = FunctionUtils.saveStream(stream);

        // Perform operations on the saved stream.

        // 1. Count the number of elements in the saved stream (should be 0 for an empty stream).
        long count = saved.get().count();
        assertEquals(0, count);

        // 2. Attempt to find the maximum element (should throw an exception for an empty stream).
        assertThrows(java.util.NoSuchElementException.class, () -> saved.get().max(Integer::compareTo).get());

        // 3. Attempt to find the minimum element (should throw an exception for an empty stream).
        assertThrows(java.util.NoSuchElementException.class, () -> saved.get().min(Integer::compareTo).get());
    }
}
