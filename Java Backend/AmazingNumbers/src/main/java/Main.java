import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to Amazing Numbers!");
            System.out.println(Program.OPTIONS);

            String output = "";

            do {
                System.out.print("\nEnter a request: ");
                String input = scanner.nextLine();
                output = Program.processRequest(input);
                System.out.print(output);
            } while (!"\nGoodbye!".equals(output));
        }

//        try (Scanner scanner = new Scanner(System.in)) {
//            System.out.println("Welcome to Amazing Numbers!");
//            String options = """
//                    \nSupported requests:
//                    - enter a natural number to know its properties;
//                    - enter two natural numbers to obtain the properties of the list:
//                      * the first parameter represents a starting number;
//                      * the second parameter shows how many consecutive numbers are to be processed;
//                    - two natural numbers and a property to search for;
//                    - two natural numbers and two properties to search for;
//                    - separate the parameters with one space;
//                    - enter 0 to exit.""";
//            System.out.println(options);
//
//            long num = -1;
//            long count;
//            String property = "";
//
//            do {
//                try {
//                    System.out.print("\nEnter a request: ");
//                    String input = scanner.nextLine();
//
//                    if ("".equals(input)) {
//                        System.out.println(options);
//                        continue;
//                    }
//
//                    String[] strings = input.split(" ");
//
//                    num = Long.parseLong(strings[0]);
//
//                    if (strings.length == 1 && num == 0) {
//                        System.out.println();
//                        break;
//                    } else if (num < 0) {
//                        System.out.println("\nThe first parameter should be a natural number or zero");
//                    } else if (strings.length == 1) {
//                        Number number = new Number(num);
//                        System.out.println(number);
//                    } else {
//                        count = Long.parseLong(strings[1]);
//
//                        if (strings.length == 3) {
//                            property = strings[2].toLowerCase();
//                            if (!"evenoddbuzzduckpalindromicgapfulspy".contains(property)) {
//                                System.out.println("The property [" + property.toUpperCase() + "] is wrong.");
//                                System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, EVEN, ODD]");
//                            } else {
//                                // only numbers with indicated property should be printed
//                                int j = 0;
//                                for (int i = 0; i < count; i++) {
//                                    Number number = new Number(num + j++);
//                                    while (!number.hasProperty(property)) {
//                                        number = new Number(num + j++);
//                                    }
//                                    number.getProperties();
//                                }
//                            }
//                        }
//
//                        if (count < 0) {
//                            System.out.println("\nThe second parameter should be a natural number");
//                        } else if (property.isEmpty()) {
//                            for (int i = 0; i < count; i++) {
//                                Number number = new Number(num + i);
//                                number.getProperties();
//                            }
//                        }
//                    }
//                } catch (NumberFormatException e) {
//                    System.out.println("\nThe first parameter should be a natural number or zero");
//                }
//            } while (num != 0);
//
//            System.out.println("Goodbye!");
//        }
    }
}