import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<Item> cart = new ArrayList<>();

    public void addToCart(Item item) {
        cart.add(item);
    }

    public String showCart(String categoryStr) {
        Category category = Category.valueOf(categoryStr);

        if (cart.stream().noneMatch(s -> s.category().equals(category))) {
            return "The purchase list is empty";
        }

        StringBuilder sb = new StringBuilder();

        cart
                .stream()
                .filter(s -> s.category().equals(category))
                .forEach(s -> sb.append(String.format("%s%n", s)));

        Double amt = cart
                .stream()
                .filter(s -> s.category().equals(category))
                .map(Item::price)
                .reduce(0.0, Double::sum);

        return sb.append(String.format("Total sum: $%.2f", amt)).toString();
    }
}
