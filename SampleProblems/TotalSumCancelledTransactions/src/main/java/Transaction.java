public class Transaction {
    private final String uuid;
    private final State state;
    private final Long sum;

    public Transaction(String uuid, State state, Long sum) {
        this.uuid = uuid;
        this.state = state;
        this.sum = sum;
    }

    public State getState() {
        return state;
    }

    public Long getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "uuid='" + uuid + '\'' +
                ", state=" + state +
                ", sum=" + sum +
                '}';
    }
}
