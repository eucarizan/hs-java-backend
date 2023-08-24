import java.util.Comparator;
import java.util.List;

public class Utils {
    public static void sortUsers(List<User> users) {
        users.sort((u1, u2) -> {
            if (u1.getName().equals(u2.getName())) {
                return Integer.compare(u2.getAge(), u1.getAge());
            }
            return u1.getName().compareTo(u2.getName());
        });
    }

    public static void sortUsersMethodRef(List<User> users) {
        users.sort(
                Comparator.comparing(User::getName)
                        .thenComparing(User::getAge, Comparator.reverseOrder()));
    }
}
