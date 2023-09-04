import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Account> accounts = List.of(
                new Account("1", 5000, true),
                new Account("2", 5000, false),
                new Account("3", 0, true),
                new Account("4", 0, false),
                new Account("5", 100_000_005, false),
                new Account("6", 100_000_005, true)
        );

    }
}