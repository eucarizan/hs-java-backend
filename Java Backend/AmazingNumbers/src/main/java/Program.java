import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Program {
    public static final String OPTIONS = """
            \nSupported requests:
            - enter a natural number to know its properties;
            - enter two natural numbers to obtain the properties of the list:
              * the first parameter represents a starting number;
              * the second parameter shows how many consecutive numbers are to be printed;
            - two natural numbers and properties to search for;
            - a property preceded by minus must not be present in numbers;
            - separate the parameters with one space;
            - enter 0 to exit.""";
    private static final String FIRST_PARAM_ERROR = "\nThe first parameter should be a natural number or zero.\n";
    private static final String SECOND_PARAM_ERROR = "\nThe second parameter should be a natural number.\n";
    private static final String PROPERTIES_MSG = "\nAvailable properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]\n";
    public static final String GOODBYE = "\nGoodbye!";
    private static final List<String> propertiesList = List.of(
            "buzz",
            "duck",
            "palindromic",
            "gapful",
            "spy",
            "square",
            "sunny",
            "jumping",
            "happy",
            "sad",
            "even",
            "odd"
    );

    public static String processRequest(String request) {
        StringBuilder sb = new StringBuilder();

        if ("".equals(request)) {
            sb.append(OPTIONS);
            sb.append("\n");
        } else {
            String[] strings = request.split(" ");
            try {
                long num = Long.parseLong(strings[0]);

                if (num == 0) {
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
        String property = "";

        if (count <= 0) {
            sb.append(SECOND_PARAM_ERROR);
            return sb.toString();
        }

        if (strings.length == 3) {
            property = strings[2].toLowerCase();
            sb.append(handleSingleProperty(num, count, property));
        } else if (strings.length > 3) {
            List<String> properties = Arrays.stream(Arrays.copyOfRange(strings, 2, strings.length))
                    .toList();
            sb.append(handleRequestWithProperties(num, count, properties));
            property = "not empty";
        }

        if (property.isEmpty()) {
            sb.append(handleRange(num, count));
        }

        return sb.toString();
    }

    private static String handleSingleProperty(long num, long count, String property) {
        StringBuilder sb = new StringBuilder("\n");

        if (!checkForNotExistingProperty(List.of(property)).isEmpty()) {
            sb.append(String.format("The property [%s] is wrong.%n", property.toUpperCase()));
            sb.append(PROPERTIES_MSG);
            return sb.toString();
        }

        sb.append(getNumberWithProperties(num, count, List.of(property)));

        return sb.toString();
    }

    private static String handleRequestWithProperties(long num, long count, List<String> properties) {
        StringBuilder sb = new StringBuilder();
        List<String> propertiesNotExist = checkForNotExistingProperty(properties);

        if (!propertiesNotExist.isEmpty()) {
            sb.append(handlePropertyNotExist(propertiesNotExist));
        } else {
            if (mutuallyExclusive(properties)) {
                sb.append(hasMutuallyExclusiveProperty(properties));
                return sb.toString();
            } else {
                sb.append(getNumberWithProperties(num, count, properties));
            }
        }

        return sb.toString();
    }

    private static List<String> checkForNotExistingProperty(List<String> properties) {
        List<String> returnProps = new ArrayList<>();
        for (String prop : properties) {
            if (prop.startsWith("-")) {
                prop = prop.substring(1);
            }

            if (!propertiesList.contains(prop)) {
                returnProps.add(prop.toUpperCase());
            }
        }

        return returnProps;
    }

    private static String handlePropertyNotExist(List<String> propertiesNotExist) {
        StringBuilder sb = new StringBuilder();
        sb.append("The properties [");
        sb.append(String.join(", ", propertiesNotExist));
        if (propertiesNotExist.size() > 1) {
            sb.append("] are wrong.");
        } else {
            sb.append("] is wrong.");
        }
        sb.append(PROPERTIES_MSG);

        return sb.toString();
    }

    private static boolean mutuallyExclusive(List<String> properties) {

        return properties.contains("even") && properties.contains("odd") ||
                properties.contains("-even") && properties.contains("-odd") ||
                properties.contains("-even") && properties.contains("even") ||
                properties.contains("-odd") && properties.contains("odd") ||
                properties.contains("duck") && properties.contains("spy") ||
                properties.contains("-duck") && properties.contains("-spy") ||
                properties.contains("-duck") && properties.contains("duck") ||
                properties.contains("-spy") && properties.contains("spy") ||
                properties.contains("sunny") && properties.contains("square") ||
                properties.contains("-sunny") && properties.contains("-square") ||
                properties.contains("-sunny") && properties.contains("sunny") ||
                properties.contains("-square") && properties.contains("square") ||
                properties.contains("-buzz") && properties.contains("buzz") ||
                properties.contains("-palindromic") && properties.contains("palindromic") ||
                properties.contains("-gapful") && properties.contains("gapful") ||
                properties.contains("-jumping") && properties.contains("jumping");
    }

    private static String hasMutuallyExclusiveProperty(List<String> properties) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%nThe request contains mutually exclusive properties: ["));

        if (properties.contains("even") && properties.contains("odd")) {
            sb.append("EVEN, ODD");
        } else if (properties.contains("-even") && properties.contains("-odd")) {
            sb.append("-EVEN, -ODD");
        } else if (properties.contains("-even") && properties.contains("even")) {
            sb.append("-EVEN, EVEN");
        } else if (properties.contains("-odd") && properties.contains("odd")) {
            sb.append("-ODD, ODD");
        } else if (properties.contains("duck") && properties.contains("spy")) {
            sb.append("DUCK, SPY");
        } else if (properties.contains("-duck") && properties.contains("-spy")) {
            sb.append("-DUCK, -SPY");
        } else if (properties.contains("-duck") && properties.contains("duck")) {
            sb.append("-DUCK, DUCK");
        } else if (properties.contains("-spy") && properties.contains("spy")) {
            sb.append("-SPY, SPY");
        } else if (properties.contains("sunny") && properties.contains("square")) {
            sb.append("SUNNY, SQUARE");
        } else if (properties.contains("-sunny") && properties.contains("-square")) {
            sb.append("-SUNNY, -SQUARE");
        } else if (properties.contains("-sunny") && properties.contains("sunny")) {
            sb.append("-SUNNY, SUNNY");
        } else if (properties.contains("-square") && properties.contains("square")) {
            sb.append("-SQUARE, SQUARE");
        } else if (properties.contains("-buzz") && properties.contains("buzz")) {
            sb.append("-BUZZ, BUZZ");
        } else if (properties.contains("-palindromic") && properties.contains("palindromic")) {
            sb.append("-PALINDROMIC, PALINDROMIC");
        } else if (properties.contains("-gapful") && properties.contains("gapful")) {
            sb.append("-GAPFUL, GAPFUL");
        } else if (properties.contains("-jumping") && properties.contains("jumping")) {
            sb.append("-JUMPING, JUMPING");
        }

        sb.append("]\nThere are no numbers with these properties.\n");

        return sb.toString();
    }

    private static String getNumberWithProperties(long num, long count, List<String> properties) {
        StringBuilder sb = new StringBuilder("\n");

        List<String> propertiesToInclude = getPropertiesList(true, properties);
        List<String> propertiesNotToInclude = getPropertiesList(false, properties);

        int j = 0;
        for (int i = 0; j < count; i++) {
            Number number = new Number(num + i);
            if (numberHasProperties(propertiesToInclude, number) && !numberHasNoProperties(propertiesNotToInclude, number)) {
                sb.append(number.getProperties());
                j++;
            }
        }

        return sb.toString();
    }

    private static boolean numberHasProperties(List<String> properties, Number number) {
        return new HashSet<>(number.getPropertiesList()).containsAll(properties);
    }

    private static boolean numberHasNoProperties(List<String> properties, Number number) {
        return number.getPropertiesList().stream().anyMatch(properties::contains);
    }

    private static String handleRange(long num, long count) {
        StringBuilder sb = new StringBuilder("\n");

        for (int i = 0; i < count; i++) {
            Number number = new Number(num + i);
            sb.append(number.getProperties());
        }

        return sb.toString();
    }

    private static List<String> getPropertiesList(boolean include, List<String> properties) {
        List<String> returnList = new ArrayList<>(properties);

        if (include) {
            return returnList.stream()
                    .filter(s -> !s.startsWith("-"))
                    .toList();
        } else {
            return returnList.stream()
                    .filter(s -> s.startsWith("-"))
                    .map(s -> s.substring(1))
                    .toList();
        }
    }
}
