import java.util.Comparator;

public class MessageAuthorComparator implements Comparator<Message> {
    @Override
    public int compare(Message m1, Message m2) {
        return m1.getFrom().compareTo(m2.getFrom());
    }
}
