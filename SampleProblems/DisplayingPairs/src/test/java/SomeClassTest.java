import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeClassTest {
    @Test
    @DisplayName("whenFormatMapThenSuccess")
    void test() {
        Map<String, Integer> map = new TreeMap<>(Map.of(
                "Alpha", 1,
                "Gamma", 3,
                "Omega", 24
        ));

        List<String> expected = List.of(
                "Alpha=1",
                "Gamma=3",
                "Omega=24"
        );

//        Pair.displayPrint(map);

        assertEquals(expected, Pair.display(map));
    }
}
