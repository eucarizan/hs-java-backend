import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] inputs = {
                "How to bake an awesome cake?-300",
                "Alice likes pancakes...But who doesn't?-800",
                "Germany wants to win EURO 2020!-500"
        };

        List<Article> articles = new ArrayList<>();
        for (String input : inputs) {
            String[] peopleStr = input.split("-");
            Article article = new Article(peopleStr[0], Integer.parseInt(peopleStr[1]));

            articles.add(article);
        }

        articles.stream().sorted().forEach(System.out::println);
    }
}
