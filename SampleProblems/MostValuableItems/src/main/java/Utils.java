import java.util.Comparator;
import java.util.List;

public class Utils {
    public static void sort(List<StockItem> stockItems) {
        stockItems.sort((item1, item2) -> {
            double totalPrice1 = item1.getQuantity() * item1.getPricePerUnit();
            double totalPrice2 = item2.getQuantity() * item2.getPricePerUnit();
            return Double.compare(totalPrice2, totalPrice1);
        });

    }

    public static List<StockItem> sortComparator(List<StockItem> stockItems) {
        stockItems.sort(Comparator.comparing(
                item -> item.getPricePerUnit() * item.getQuantity(),
                Comparator.reverseOrder()));

        return stockItems;
    }
}
