import java.util.List;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        List<Account> accounts = List.of(
                new Account(3333L, "530012", Status.ACTIVE),
                new Account(15000L, "771843", Status.BLOCKED),
                new Account(15000L, "234465", Status.ACTIVE),
                new Account(8800L, "110011", Status.ACTIVE),
                new Account(45000L, "462181", Status.BLOCKED),
                new Account(0L, "681891", Status.REMOVED)
        );

        Report report = accounts.stream().collect(
                teeing(
                        filtering(Account::isBlocked, mapping(Account::getNumber, toList())),
                        filtering(Account::isActive, mapping(Account::getNumber, toList())),
                        Report::new
                )
        );

        System.out.println(report);
    }
}