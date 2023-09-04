public class Account {
    private String number;
    private long balance;
    private boolean locked;

    public Account(String number, long balance, boolean locked) {
        this.number = number;
        this.balance = balance;
        this.locked = locked;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                ", isLocked=" + locked +
                '}';
    }
}
