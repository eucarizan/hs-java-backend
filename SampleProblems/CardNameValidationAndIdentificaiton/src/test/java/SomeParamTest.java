import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeParamTest {

    @ParameterizedTest(name = "Test{index} ({0}) with card number ({1})")
    @CsvSource(value = {
            "Visa:4235 2345 6543 1234",
            "MasterCard:2221 2341 2345 1234",
            "AmericanExpress:371 4496 3539 8431",
            "MasterCard:2578 2345 1234 6499",
            "Card number does not exist:2221 234y 2345 1234"},
            delimiter = ':')
    public void test(String expected, String card) {
        assertEquals(expected, BankCard.findNetwork(card.replaceAll("\\s", "")));
    }
}
