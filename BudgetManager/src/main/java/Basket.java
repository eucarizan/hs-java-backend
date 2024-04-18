import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<Item> cart = new ArrayList<>();

    public void addToCart(Item item) {
        cart.add(item);
    }

    public String showCart(String categoryStr) {
        if ("all".equalsIgnoreCase(categoryStr)) {
            return showAllCart();
        }

        Category category = Category.valueOf(categoryStr.toUpperCase());

        if (cart.stream().noneMatch(s -> s.category().equals(category))) {
            return "The purchase list is empty";
        }

        String cat = categoryStr.substring(0, 1).toUpperCase() + categoryStr.substring(1);
        StringBuilder sb = new StringBuilder(cat + ":\n");

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

    private String showAllCart() {
        StringBuilder sb = new StringBuilder("All:\n");
        cart
                .forEach(s -> sb.append(String.format("%s%n", s)));

        Double amt = cart
                .stream()
                .map(Item::price)
                .reduce(0.0, Double::sum);

        return sb.append(String.format("Total sum: $%.2f", amt)).toString();
    }
}
