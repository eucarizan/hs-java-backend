public class Transaction {
    private final String uuid;
    private final Long sum;
    private final Account account;

    public Transaction(String uuid, Long sum, Account account) {
        this.uuid = uuid;
        this.sum = sum;
        this.account = account;
    }

    public String getUuid() {
        return uuid;
    }

    public Long getSum() {
        return sum;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "uuid='" + uuid + '\'' +
                ", sum=" + sum +
                '}';
    }
}
