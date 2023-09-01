import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@SuppressWarnings("unused")
public class SomeParamTest {

    @ParameterizedTest(name = "{0} calcSumOfCanceledTransOnNonEmptyAccounts(<empty list>) == {1}")
    @DisplayName("paramTest")
    @CsvSource(value = {
            "testEmpty : 0"
    }, delimiter = ':')
    public void test(String name, long expected) {
        List<Account> accounts = List.of();

        long result = StreamPipelines.calcSumOfCanceledTransOnNonEmptyAccounts(accounts);

        assertEquals(expected, result);
    }

    @Test
    void testSample() {
        List<Account> accounts = Arrays.asList(
                new Account("1001", 0L,
                        List.of(new Transaction("774cedda-9cde-4f53-8bc2-5b4d4859772a", State.CANCELED, 1_000L))),
                new Account("1002", 8000L,
                        Arrays.asList(
                                new Transaction("337868a7-f469-43c0-9042-3422ce37ee26a", State.FINISHED, 8_000L),
                                new Transaction("f8047f86-89e7-4226-8b75-74c55a4d7e31", State.CANCELED, 10_000L)
                        ))
        );

        long expectedSum = 10_000L;
        long actualSum = StreamPipelines.calcSumOfCanceledTransOnNonEmptyAccounts(accounts);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testCalcSumOfCanceledTransOnNonEmptyAccountsWithEmptyAccounts() {
        List<Account> accounts = new ArrayList<>();
        long expectedSum = 0;

        long actualSum = StreamPipelines.calcSumOfCanceledTransOnNonEmptyAccounts(accounts);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testCalcSumOfCanceledTransOnNonEmptyAccountsWithNoCanceledTransactions() {
        List<Account> accounts = Arrays.asList(
                new Account("1001", 2000L, Arrays.asList(
                        new Transaction("774cedda-9cde-4f53-8bc2-5b4d4859772a", State.FINISHED, 1000L),
                        new Transaction("f8047f86-89e7-4226-8b75-74c55a4d7e31", State.FINISHED, 1000L)
                )),
                new Account("1002", 8000L, List.of(
                        new Transaction("337868a7-f469-43c0-9042-3422ce37ee26a", State.FINISHED, 8000L)
                ))
        );
        long expectedSum = 0;

        long actualSum = StreamPipelines.calcSumOfCanceledTransOnNonEmptyAccounts(accounts);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testCalcSumOfCanceledTransOnNonEmptyAccountsWithNegativeBalance() {
        List<Account> accounts = Arrays.asList(
                new Account("1001", -500L, List.of(
                        new Transaction("774cedda-9cde-4f53-8bc2-5b4d4859772a", State.CANCELED, 1000L)
                )),
                new Account("1002", 0L, Arrays.asList(
                        new Transaction("337868a7-f469-43c0-9042-3422ce37ee26a", State.CANCELED, 2000L),
                        new Transaction("f8047f86-89e7-4226-8b75-74c55a4d7e31", State.CANCELED, 3000L)
                ))
        );
        long expectedSum = 0;

        long actualSum = StreamPipelines.calcSumOfCanceledTransOnNonEmptyAccounts(accounts);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testCalcSumOfCanceledTransOnNonEmptyAccountsWithAllCanceledTransactions() {
        List<Account> accounts = Arrays.asList(
                new Account("1001", 2000L, Arrays.asList(
                        new Transaction("774cedda-9cde-4f53-8bc2-5b4d4859772a", State.CANCELED, 1000L),
                        new Transaction("f8047f86-89e7-4226-8b75-74c55a4d7e31", State.CANCELED, 300L)
                )),
                new Account("1002", 5000L, Arrays.asList(
                        new Transaction("337868a7-f469-43c0-9042-3422ce37ee26a", State.CANCELED, 2000L),
                        new Transaction("b5a4d3c2-1f2g3h4i5", State.CANCELED, 1500L)
                ))
        );
        long expectedSum = 4800;

        long actualSum = StreamPipelines.calcSumOfCanceledTransOnNonEmptyAccounts(accounts);

        assertEquals(expectedSum, actualSum);
    }
}
