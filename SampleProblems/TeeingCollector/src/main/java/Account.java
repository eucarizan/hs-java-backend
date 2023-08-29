public class Account {
    private final long balance;
    private final String number;
    private final Status status;

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

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", number='" + number + '\'' +
                ", status=" + status +
                '}';
    }
}
