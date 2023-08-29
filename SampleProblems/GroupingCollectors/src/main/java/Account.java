public class Account {
    private long balance;
    private String number;
    private Status status;

    public Account(long balance, String number, Status stats) {
        this.balance = balance;
        this.number = number;
        this.status = stats;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", number='" + number + '\'' +
                ", status=" + status +
                '}';
    }
}
