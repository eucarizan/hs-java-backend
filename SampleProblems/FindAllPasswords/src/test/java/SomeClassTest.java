import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeClassTest {

    @Test
    @DisplayName("givenStringWithTwoPasswordsWhenFindPasswordThenExpectTwoPasswords")
    void test1() {
        List<String> expected = List.of("SECRET115", "PASS");
        String input = "My email javacoder@gmail.com with password    SECRET115. Here is my old PASSWORD: PASS.";

        List<String> result = Password.find(input);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("givenStringWithNoPasswordWhenFindPasswordThenExpectNoPasswordFound")
    void test2() {
        List<String> expected = List.of("No passwords found.");
        String input = "My email is javacoder@gmail.com.";

        List<String> result = Password.find(input);

        assertEquals(expected, result);
    }
}
