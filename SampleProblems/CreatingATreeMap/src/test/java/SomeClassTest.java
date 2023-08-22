import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeClassTest {
    @Test
    void test() {
        List<String> inputs = List.of(
                "Omega - 24",
                "Alpha - 1",
                "Gamma - 3"
        );

        String expected = "{Alpha=1, Gamma=3, Omega=24}";
        String result = CreateMap.createTreeMap(inputs);

        assertEquals(expected, result);
    }
}
