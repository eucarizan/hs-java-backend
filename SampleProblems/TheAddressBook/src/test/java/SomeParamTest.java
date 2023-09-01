import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} getAddressByName({1}) == {2}")
    @CsvSource(value = {
            "testPresent : Christina Doss : Christina Doss lives at 7 Lincoln St., Matawan, NJ 07747",
            "testNotPresent : Aubrey Curry : Unknown"
    }, delimiter = ':')
    public void test(String name, String input, String expected) {

        Optional<String> result = AddressBook.getAddressByName(input);

        assertEquals(expected, result.map(addr -> input + " lives at " + addr).orElse("Unknown"));
    }

    @Test
    public void testGetAddressByNameWithNullInput() {
        String name = null;
        Optional<String> expectedAddress = Optional.empty();

        Optional<String> actualAddress = AddressBook.getAddressByName(name);

        assertEquals(expectedAddress, actualAddress);
    }

    @Test
    public void testGetAddressByNameWithEmptyInput() {
        String name = "";
        Optional<String> expectedAddress = Optional.empty();

        Optional<String> actualAddress = AddressBook.getAddressByName(name);

        assertEquals(expectedAddress, actualAddress);
    }
}
