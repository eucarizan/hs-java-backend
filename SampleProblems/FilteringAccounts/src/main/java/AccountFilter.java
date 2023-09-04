import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountFilter {
    public static List<Account> nonEmptyAccounts(List<Account> accounts) {
        return filter(accounts, account -> account.getBalance() > 0);
    }

    public static List<Account> accountsWithTooMuchMoney(List<Account> accounts) {
        return filter(accounts, account -> !account.isLocked() && account.getBalance() >= 100_000_000);
    }

    private static <T> List<T> filter(List<T> elems, Predicate<T> predicate) {
        return elems.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static List<String> concatenatedAccountNumbers(List<Account> accounts) {
        List<Account> emptyAccounts = AccountFilter.nonEmptyAccounts(accounts);
        List<Account> tooMuchMoney = AccountFilter.accountsWithTooMuchMoney(accounts);

        return Stream.concat(emptyAccounts.stream(), tooMuchMoney.stream())
                .map(Account::getNumber)
                .toList();
    }
}
