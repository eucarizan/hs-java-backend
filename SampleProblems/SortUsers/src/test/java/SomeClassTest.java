import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeClassTest {
    @Test
    @DisplayName("")
    void test1() {
        List<User> users1 = new ArrayList<>();
        List<User> users2 = new ArrayList<>();
        String[] inputs1 = "Mike Ginger Alice Bob".split(" ");
        String[] inputs2 = "microprogrammer Moses Chloe user".split(" ");

        for (String input : inputs1) {
            users1.add(new User(input));
        }
        for (String input : inputs2) {
            users2.add(new User(input));
        }

        Users.sort(users1);
        Users.sort(users2);

        StringBuilder sb1 = new StringBuilder();
        users1.forEach(user -> sb1.append(user).append(" "));
        StringBuilder sb2 = new StringBuilder();
        users2.forEach(user -> sb2.append(user).append(" "));

        assertEquals("Alice Bob Ginger Mike", sb1.toString().trim());
        assertEquals("Chloe Moses microprogrammer user", sb2.toString().trim());
    }
}
