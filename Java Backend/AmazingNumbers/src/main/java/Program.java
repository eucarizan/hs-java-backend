public class Program {
    public static final String OPTIONS = """
            \nSupported requests:
            - enter a natural number to know its properties;
            - enter two natural numbers to obtain the properties of the list:
              * the first parameter represents a starting number;
              * the second parameter shows how many consecutive numbers are to be processed;
            - two natural numbers and a property to search for;
            - two natural numbers and two properties to search for;
            - separate the parameters with one space;
            - enter 0 to exit.""";
    private static final String FIRST_PARAM_ERROR = "\nThe first parameter should be a natural number or zero.\n";
    private static final String SECOND_PARAM_ERROR = "\nThe second parameter should be a natural number.\n";
    private static final String PROPERTIES_MSG = "\nAvailable properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]\n";
    public static final String GOODBYE = "\nGoodbye!";

    public static String processRequest(String request) {
        StringBuilder sb = new StringBuilder();

        if ("".equals(request)) {
            sb.append(OPTIONS);
            sb.append("\n");
        } else {
            String[] strings = request.split(" ");
            try {
                long num = Long.parseLong(strings[0]);

                if (num == 0 /*&& strings.length == 1*/) {
                    sb.append(GOODBYE);
                } else if (num < 0) {
                    sb.append(FIRST_PARAM_ERROR);
                } else if (strings.length == 1) {
                    Number number = new Number(num);
                    sb.append(number);
                } else {
                    sb.append(handleRequestWithProperty(num, strings));
                }
            } catch (NumberFormatException e) {
                sb.append(FIRST_PARAM_ERROR);
            }
        }

        return sb.toString();
    }

    private static String handleRequestWithProperty(long num, String[] strings) {
        StringBuilder sb = new StringBuilder();

        long count = Long.parseLong(strings[1]);
        String property1 = "";

        if (count <= 0) {
            sb.append(SECOND_PARAM_ERROR);
            return sb.toString();
        }

        if (strings.length == 3) {
            property1 = strings[2].toLowerCase();
            sb.append(handleSingleProperty(num, count, property1));
        } else if (strings.length == 4) {
            property1 = strings[2].toLowerCase();
            String property2 = strings[3].toLowerCase();
            sb.append(handleRequestWithProperties(num, count, property1, property2));
        }

        if (property1.isEmpty()) {
            sb.append(handleRange(num, count));
        }

        return sb.toString();
    }

    private static String handleSingleProperty(long num, long count, String property) {
        StringBuilder sb = new StringBuilder("\n");

        if (propertyNotExists(property)) {
            sb.append(String.format("The property [%s] is wrong.%n", property.toUpperCase()));
            sb.append(PROPERTIES_MSG);
            return sb.toString();
        }

        for (int i = 0, j = 0; i < count; i++) {
            Number number = new Number(num + j++);
            while (number.hasProperty(property)) {
                number = new Number(num + j++);
            }
            sb.append(number.getProperties());
        }

        return sb.toString();
    }

    private static String handleRequestWithProperties(long num, long count, String prop1, String prop2) {
        StringBuilder sb = new StringBuilder();

        if (propertyNotExists(prop1)) {
            if (propertyNotExists(prop2)) {
                sb.append(String.format("%nThe properties [%s, %s] are wrong.", prop1.toUpperCase(), prop2.toUpperCase()));
            } else {
                sb.append(String.format("%nThe property [%s] is wrong.", prop1.toUpperCase()));
            }
            sb.append(PROPERTIES_MSG);
        } else if (propertyNotExists(prop2)) {
            sb.append(String.format("%nThe property [%s] is wrong.", prop2.toUpperCase()));
            sb.append(PROPERTIES_MSG);
        } else {
            if (mutuallyExclusive(prop1, prop2)) {
                sb.append(String.format("%nThe request contains mutually exclusive properties: [%s, %s]%n", prop1.toUpperCase(), prop2.toUpperCase()));
                sb.append("There are no numbers with these properties.\n");
                return sb.toString();
            } else {
                sb.append("\n");
                int j = 0;
                for (int i = 0; i < count; i++) {
                    Number number = new Number(num + j++);
                    while (!number.hasProperty(prop1) && number.hasProperty(prop2) ||
                            number.hasProperty(prop1) && !number.hasProperty(prop2) ||
                            !number.hasProperty(prop1) && !number.hasProperty(prop2)
                    ) {
                        number = new Number(num + j++);
                    }
                    sb.append(number.getProperties());
                }
            }
        }

        return sb.toString();
    }

    private static String handleRange(long num, long count) {
        StringBuilder sb = new StringBuilder("\n");

        for (int i = 0; i < count; i++) {
            Number number = new Number(num + i);
            sb.append(number.getProperties());
        }

        return sb.toString();
    }

    private static boolean propertyNotExists(String property) {
        return !switch (property) {
            case "even", "odd", "buzz", "duck", "palindromic",
                    "gapful", "spy", "square", "sunny" -> true;
            default -> false;
        };
    }

    private static boolean mutuallyExclusive(String prop1, String prop2) {
        if ("even".equals(prop1) && "odd".equals(prop2) || "odd".equals(prop1) && "even".equals(prop2)) {
            return true;
        } else if ("duck".equals(prop1) && "spy".equals(prop2) || "spy".equals(prop1) && "duck".equals(prop2)) {
            return true;
        } else
            return "sunny".equals(prop1) && "square".equals(prop2) || "square".equals(prop1) && "sunny".equals(prop2);
    }
}
