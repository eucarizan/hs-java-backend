# Teeing collector

## Description
Take a look at these classes:

```java
enum Status {ACTIVE, BLOCKED, REMOVED}

class Account {
    private long balance;
    private String number;
    private Status status;

    public Account(long balance, String number, Status status) {
        this.balance = balance;
        this.number = number;
        this.status = status;
    }

    public long getBalance() { return balance; }
    public String getNumber() { return number; }
    public Status getStatus() { return status; }
    public boolean isBlocked() { return status == Status.BLOCKED; }
    public boolean isActive() { return status == Status.ACTIVE; }
}

class Report {
    List<String> blocked;
    List<String> active;

    public Report(List<String> blocked, List<String> active) {
        this.blocked = blocked;
        this.active = active;
    }

    @Override
    public String toString() { return blocked + ", " + active; }
}
```

What will the following code print to the console?

```java
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
```

## Choices
- [x] [771843, 462181], [530012, 234465, 110011]
- [ ] [771843, 462181], [530012, 234465, 110011], [681891]
- [ ] [771843, 462181, 530012, 234465, 110011]
- [ ] [530012, 234465, 110011], [771843, 462181]

## Tags
- functional programming
- functional streams
- grouping collectors