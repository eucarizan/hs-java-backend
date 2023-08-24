import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "Test{index} sort({0}) == {1}")
    @CsvSource(value = {
            "John=25 Jane=25 Jim=18 Jack=18 John=30:[Jack=18, Jane=25, Jim=18, John=30, John=25]",
            "Abby=19 Alice=19 Abby=21 Alice=21 Ashley=19:[Abby=21, Abby=19, Alice=21, Alice=19, Ashley=19]"}
            ,delimiter = ':'
    )
    public void test(String input, String expected) {
        List<User> users = new ArrayList<>();

        String[] inputs = input.split(" ");
        for (String s : inputs) {
            String[] personStr = s.split("=");
            users.add(new User(personStr[0], Integer.parseInt(personStr[1])));
        }

        Utils.sortUsers(users);

        assertEquals(expected, users.toString());
    }
}
