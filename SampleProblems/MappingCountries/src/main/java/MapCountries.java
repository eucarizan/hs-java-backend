import java.util.List;

public class MapCountries {
    public static List<Integer> countNumbers(List<String> countries) {
        return countries.stream()
                .map(country -> country.split("\\s+"))
                .map(country -> country.length)
                .toList();
    }
}
