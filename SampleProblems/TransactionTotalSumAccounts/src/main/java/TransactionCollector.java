import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionCollector {
    public static Map<String, Long> getAccount2TransSum(List<Transaction> transactions) {
        return transactions.stream().collect(
                Collectors.groupingBy(
                        transaction -> transaction.getAccount().getNumber(),
                        Collectors.summingLong(Transaction::getSum)
                )
        );
    }
}
