import java.util.List;

public class Basket {
    public String processCart(List<String> cart) {
//        Map<String, Double> itemPrices = cart.stream()
//                .map(s -> s.split("\\$"))
//                .collect(Collectors.toMap(parts -> parts[0].trim(), parts -> Double.parseDouble(parts[1])));
//        itemPrices.forEach((key, value) -> System.out.println(key + " = $" + value));
        StringBuilder sb = new StringBuilder();

        cart.forEach(s -> sb.append(String.format("%s%n", s)));

        Double amt = cart.stream()
                .map(s -> s.split("\\$"))
                .map(s -> Double.parseDouble(s[1]))
                .reduce(0.0, Double::sum);

        return sb.append(String.format("%nTotal: $%.2f", amt)).toString();
    }
}
