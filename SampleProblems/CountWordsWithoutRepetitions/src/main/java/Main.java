import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<List<String>> lines = List.of(
                List.of("Word", "word", "wORD"),
                List.of("line", "Line", "SplinE", "word"),
                List.of("spline", "align", "Java", "java")
        );

        System.out.println(Words.countWithoutRepetitions(3, lines));
    }
}