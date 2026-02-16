package ua.opnu;

public class BookData implements Comparable<BookData> {
    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getReviews() {
        return reviews;
    }

    public double getTotal() {
        return total;
    }

    public double getRating() {
        if (reviews == 0) {
            return 0.0; // якщо немає оцінок, рейтинг 0
        }
        return total / reviews;
    }

    @Override
    public int compareTo(BookData other) {
        double thisRating = this.getRating();
        double otherRating = other.getRating();

        if (thisRating > otherRating) {
            return -1;
        } else if (thisRating < otherRating) {
            return 1;
        } else {
            return this.title.compareTo(other.title);
        }
    }

    @Override
    public String toString() {
        return String.format("'%s' by %s | рейтинг: %.2f (голосів: %d, сума: %.1f)",
                title, author, getRating(), reviews, total);
    }
}