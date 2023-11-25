public class Manager {
    private final Person person = new Person();

    public String processRequest(String input) {
        String[] parts = input.split(", ");
        int choice = Integer.parseInt(parts[0]);
        return switch (choice) {
            case 1 -> addIncome(parts[1]);
            case 2 -> addPurchase(parts[1]);
            case 3 -> showPurchase();
            case 4 -> showBalance();
            case 0 -> "Bye!";
            default -> "Invalid choice";
        };
    }

    public String showMenu() {
        return """
                Choose your action:
                1) Add income
                2) Add purchase
                3) Show list of purchases
                4) Balance
                0) Exit""";
    }

    private String addIncome(String incomeStr) {
        int income = Integer.parseInt(incomeStr);
        person.setBalance(income);
        return "Income was added!";
    }

    private String addPurchase(String itemStr) {
        String[] parts = itemStr.split("; ");
        Item item = new Item(parts[0], Double.parseDouble(parts[1]));
        person.addPurchase(item);
        return "Purchase was added!";
    }

    private String showPurchase() {
        return person.showPurchase();
    }

    private String showBalance() {
        return person.getBalance();
    }
}
