import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Account> accounts = List.of(
                new Account(3333L, "530012", Status.REMOVED),
                new Account(15000L, "771843", Status.ACTIVE),
                new Account(0L, "681891", Status.BLOCKED)
        );

        // partitioning
        Map<Boolean, List<Account>> accountsByBalance = accounts.stream()
                .collect(Collectors.partitioningBy(account -> account.getBalance() >= 10000));

        System.out.println(accountsByBalance);

        // grouping
        Map<Status, List<Account>> accountByStatus = accounts.stream()
                .collect(Collectors.groupingBy(Account::getStatus));

        System.out.println(accountByStatus);

        // downstream collectors
        List<Account> accountList = List.of(
                new Account(3333L, "530012", Status.ACTIVE),
                new Account(15000L, "771843", Status.BLOCKED),
                new Account(15000L, "234465", Status.ACTIVE),
                new Account(8800L, "110011", Status.ACTIVE),
                new Account(45000L, "462181", Status.BLOCKED),
                new Account(0L, "681891", Status.REMOVED)
        );

        Map<Status, Long> sumByStatus = accountList.stream()
                .collect(Collectors.groupingBy(
                        Account::getStatus,
                        Collectors.summingLong(Account::getBalance)
                ));

        System.out.println(sumByStatus);

        // useful if you wish to specify the exact implementation of the Map interface
        Map<Status, Long> sumByStatuses = accounts.stream()
                .collect(Collectors.groupingBy(
                        Account::getStatus,
                        LinkedHashMap::new,
                        Collectors.summingLong(Account::getBalance))
                );

        // teeing collector
        long[] countAndSum = accountList.stream()
                .filter(account -> account.getStatus() == Status.BLOCKED)
                .collect(Collectors.teeing(
                        Collectors.counting(),
                        Collectors.summingLong(Account::getBalance),
                        (count, sum) -> new long[]{count, sum}
                ));

        System.out.println(Arrays.toString(countAndSum));
    }
}