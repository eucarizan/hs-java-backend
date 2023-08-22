import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeClassTest {

    @Test
    void whenCompareTwoAnagramThenSuccess() {
        String expected = "yes";
        assertEquals(expected, Sherlock.isAnagram("ppaaagg", "gagaapp"));
    }

    @Test
    void whenCompareTwoNonAnagramThenFail() {
        assertEquals("no", Sherlock.isAnagram("hello", "helllo"));
    }

    @Test
    void test3() {
        System.out.println(Sherlock.isAnagram("jjkoop", "JJpkoo"));
    }
}
