class Article implements Comparable<Article> {
    private final String title;
    private final int size;

    public Article(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Article otherArticle) {
        // add your code here!
        if (size == otherArticle.getSize()) {
            return title.compareTo(otherArticle.getTitle());
        }
        return size - otherArticle.getSize();
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", size=" + size +
                '}';
    }
}