import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(Utils.sortPrint(Stream.of("class", "interface", "type", "enum", "function")));
    }
}