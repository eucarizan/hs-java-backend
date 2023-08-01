public class Main {
    public static void main(String[] args) {
        Publication publication = new Publication("The new era");
        Newspaper newspaper = new Newspaper("Football results", "Sport news");
        Article article = new Article("Why the Sun is hot", "Dr James Smith");
        Announcement announcement = new Announcement("Will sell a house", 30);

        System.out.println(publication.getInfo());
        System.out.println(newspaper.getInfo());
        System.out.println(article.getInfo());
        System.out.println(announcement.getInfo());
    }
}

class Publication {

    private final String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {
        // write your code here
        return getType() + getDetails() + ": " + title;
    }

    public String getType() {
        return "Publication";
    }

    public String getDetails() {
        return "";
    }

}

class Newspaper extends Publication {

    private final String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }

    // write your code here
    @Override
    public String getType() {
        return "Newspaper";
    }

    @Override
    public String getDetails() {
        return " (source - " + source + ")";
    }
}

class Article extends Publication {

    private final String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    // write your code here
    @Override
    public String getType() {
        return "Article";
    }

    @Override
    public String getDetails() {
        return " (author - " + author + ")";
    }
}

class Announcement extends Publication {

    private final int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    // write your code here
    @Override
    public String getType() {
        return "Announcement";
    }

    @Override
    public String getDetails() {
        return " (days to expire - " + daysToExpire + ")";
    }
}
