import java.util.Comparator;

public class MessageDateComparator implements Comparator<Message> {
    @Override
    public int compare(Message m1, Message m2) {
        return m1.getCreated().compareTo(m2.getCreated());
    }
}
