import java.util.List;

public class Report {
    List<String> blocked;
    List<String> active;

    public Report(List<String> blocked, List<String> active) {
        this.blocked = blocked;
        this.active = active;
    }

    @Override
    public String toString() { return blocked + ", " + active; }
}
