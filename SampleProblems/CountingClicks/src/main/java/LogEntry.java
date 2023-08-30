import java.util.Date;

public class LogEntry {
    private final Date created;
    private final String login;
    private String url;

    public LogEntry(Date created, String login, String url) {
        this.created = created;
        this.login = login;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LogEntry)) {
            return false;
        }

        LogEntry logEntry = (LogEntry) o;

        if (!login.equals(logEntry.login)) {
            return false;
        }
        return url.equals(logEntry.url);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                ", created=" + created +
                ", login='" + login + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
