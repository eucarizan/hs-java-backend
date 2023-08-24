import java.util.Comparator;
import java.util.List;

public class Users {
    public static void sort(List<User> users) {
        users.sort(Comparator.comparing(User::getName));
    }
}
