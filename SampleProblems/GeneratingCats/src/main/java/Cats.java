import java.util.Collections;
import java.util.List;

public class Cats {
    public static List<Cat> generate(int n) {
//        return Stream.generate(Cat::new).limit(n).toList();
        return Collections.nCopies(n, new Cat());
    }
}

