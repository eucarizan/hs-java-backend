import java.util.List;

public class StreamPipelines {
    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {
        return accounts.stream()
                .filter(account -> account.getBalance() > 0)
                .flatMap(account -> account.getTransactions().stream())
                .filter(tx -> tx.getState().equals(State.CANCELED))
                .mapToLong(Transaction::getSum)
                .sum();
    }
}
