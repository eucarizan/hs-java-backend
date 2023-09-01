import java.util.List;

public class Account {
    private final String number;
    private final Long balance;
    private final List<Transaction> transactions;

    public Account(String number, Long balance, List<Transaction> transactions) {
        this.number = number;
        this.balance = balance;
        this.transactions = transactions;
    }

    public Long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
