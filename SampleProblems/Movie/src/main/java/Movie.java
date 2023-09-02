public class Movie {
    private final String title;
    private final String desc;
    private final int year;

    public Movie(String title, String desc, int year) {
        this.title = title;
        this.desc = desc;
        this.year = year;
    }

    public Movie(String title, int year) {
        this(title, "empty", year);
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getYear() {
        return year;
    }
}
