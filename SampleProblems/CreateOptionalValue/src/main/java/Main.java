import java.util.Optional;

class Main {
    public static void main(String[] args) {
        InputStringReader reader = new InputStringReader();
        Optional<String> value = reader.getValue();
        if (value.isPresent()) {
            System.out.println("Value is present: " + value.get());
        } else {
            System.out.println("Value is empty");
        }
    }
}

class InputStringReader {
    public Optional<String> getValue() {
        // implement
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        if ("empty".equals(input)) {
            return Optional.ofNullable(null);
        }
        return Optional.of(input);
    }
}