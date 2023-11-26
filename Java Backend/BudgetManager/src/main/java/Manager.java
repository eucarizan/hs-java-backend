public class Manager {
    private final Person person = new Person();
    public static final String MENU = """
            Choose your action:
            1) Add income
            2) Add purchase
            3) Show list of purchases
            4) Balance
            0) Exit""";

    public static final String CATEGORIES = """
            Choose the type of purchase
            1) Food
            2) Clothes
            3) Entertainment
            4) Other
            5) Back""";

    public static final String PURCHASE_TYPES = """
            Choose the type of purchases
            1) Food
            2) Clothes
            3) Entertainment
            4) Other
            5) All
            6) Back""";

    public String processRequest(String input) {
        String[] parts = input.split(", ");
        int choice = Integer.parseInt(parts[0]);
        return switch (choice) {
            case 1 -> addIncome(parts[1]);
            case 2 -> addPurchase(parts[1]);
            case 3 -> showPurchase(parts[1]);
            case 4 -> showBalance();
            case 0 -> "Bye!";
            default -> "Invalid choice";
        };
    }

    private String addIncome(String incomeStr) {
        int income = Integer.parseInt(incomeStr);
        person.setBalance(income);
        return "Income was added!";
    }

    private String addPurchase(String itemStr) {
        String[] parts = itemStr.split("; ");
        Item item = new Item(
                parts[0],
                Double.parseDouble(parts[1]),
                Category.valueOf(parts[2].toUpperCase()));
        person.addPurchase(item);
        return "Purchase was added!";
    }

    private String showPurchase(String categoryInt) {
        int category = Integer.parseInt(categoryInt);

        if (category == 6) {
            return "back";
        }

        String categoryStr = switch (category) {
            case 1 -> "food";
            case 2 -> "clothes";
            case 3 -> "entertainment";
            case 4 -> "other";
            case 5 -> "all";
            default -> throw new IllegalStateException("Unexpected value: " + category);
        };

        return person.showPurchase(categoryStr.toUpperCase());
    }

    private String showBalance() {
        return person.getBalance();
    }
}
