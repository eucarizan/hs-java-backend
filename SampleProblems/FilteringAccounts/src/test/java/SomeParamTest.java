import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} filter(accounts) == {2}")
    @DisplayName("param test")
    @CsvSource(value = {
            "testSample : 1, 5000, true; 2, 5000, false; 3, 0, true; 4, 0, false; 5, 1000000005, false; 6, 1000000005, true : [1, 2, 5, 6, 5]"
    }, delimiter = ':')
    public void test(String name, String input, String expected) {
        String[] paramStr = input.split("; ");
        List<Account> param = new ArrayList<>();

        for (String s : paramStr) {
            String[] parts = s.split(", ");
            String number = parts[0];
            long balance = Long.parseLong(parts[1]);
            boolean isLocked = Boolean.parseBoolean(parts[2]);
            param.add(new Account(number, balance, isLocked));
        }

        List<Account> emptyAccounts = AccountFilter.nonEmptyAccounts(param);
        List<Account> tooMuchMoney = AccountFilter.accountsWithTooMuchMoney(param);

        List<String> result = Stream.concat(emptyAccounts.stream(), tooMuchMoney.stream())
                .map(Account::getNumber)
                .toList();

        assertEquals(expected, result.toString());
    }

    @Test
    public void testConcatenatedAccountNumbersWithEmptyList() {
        List<Account> accounts = List.of();

        List<String> result = AccountFilter.concatenatedAccountNumbers(accounts);

        // For an empty list, the result should also be an empty list.
        assertTrue(result.isEmpty());
    }

    @Test
    public void testConcatenatedAccountNumbersWithNoMatchingAccounts() {
        List<Account> accounts = List.of(
                new Account("1", 0, true),
                new Account("2", 0, false),
                new Account("3", 0, true),
                new Account("4", 0, false)
        );

        List<String> result = AccountFilter.concatenatedAccountNumbers(accounts);

        // None of the accounts match the filtering criteria, so the result should be an empty list.
        assertTrue(result.isEmpty());
    }

    @Test
    public void testConcatenatedAccountNumbersWithAllMatchingAccounts() {
        List<Account> accounts = List.of(
                new Account("1", 100_000_000, false),
                new Account("2", 100_000_000, true),
                new Account("3", 100_000_000, false),
                new Account("4", 100_000_000, true)
        );

        List<String> result = AccountFilter.concatenatedAccountNumbers(accounts);

        // All accounts match the filtering criteria, so the result should contain all their account numbers.
        List<String> expected = List.of("1", "2", "3", "4", "1", "3");
        assertEquals(expected, result);
    }

    @Test
    public void testConcatenatedAccountNumbersWithMixedAccounts() {
        List<Account> accounts = List.of(
                new Account("1", 100_000_000, false),
                new Account("2", 5000, false),
                new Account("3", 0, false),
                new Account("4", 100_000_000, true),
                new Account("5", 5000, true)
        );

        List<String> result = AccountFilter.concatenatedAccountNumbers(accounts);

        // Only accounts 1 and 4 match the filtering criteria, so the result should contain their account numbers.
        List<String> expected = List.of("1", "2", "4", "5", "1");
        assertEquals(expected, result);
    }

}
