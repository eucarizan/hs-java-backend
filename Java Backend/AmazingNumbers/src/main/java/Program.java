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
    private static final String PROPERTIES_MSG = "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY]\n";
    private static final String PROPERTIES = "evenoddbuzzduckpalindromicgapfulspysquaresunny";
    public static final String GOODBYE = "\nGoodbye!";

    public static String processRequest(String request) {
        StringBuilder sb = new StringBuilder();

        if ("".equals(request)) {
            sb.append(OPTIONS);
        } else {
            String[] strings = request.split(" ");
            try {
                long num = Long.parseLong(strings[0]);

                if (strings.length == 1 && num == 0) {
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
    
    private static String handleSingleProperty(long num, long count, String property) {
        StringBuilder sb = new StringBuilder("\n");
        
        for (int i = 0, j = 0; i < count; i++) {
            Number number = new Number(num + j++);
            while (!number.hasProperty(property)) {
                number = new Number(num + j++);
            }
            sb.append(number.getProperties());
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

    private static String handleRequestWithProperty(long num, String[] strings) {
        StringBuilder sb = new StringBuilder();

        long count = Long.parseLong(strings[1]);
        String property = "";

        if (strings.length == 3) {
            property = strings[2].toLowerCase();

            if (!PROPERTIES.contains(property)) {
                sb.append(String.format("%nThe property [%s] is wrong.%n", property.toUpperCase()));
                sb.append(PROPERTIES_MSG);
            } else {
                sb.append(handleSingleProperty(num, count, property));
            }
        }

        if (count < 0) {
            sb.append(SECOND_PARAM_ERROR);
        } else if (property.isEmpty()) {
            sb.append(handleRange(num, count));
        }

        return sb.toString();
    }
}
