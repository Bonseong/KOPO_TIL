package library;

public class Book {
    private final String title;
    private final String genre;
    private boolean isBorrowed;
    private String borrowedId;
    private String borrowedDate;
    private int borrowCount;

    public Book(String title, String genre) {
        this.title = title;
        this.genre = genre;
        isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getBorrowedId() {
        return borrowedId;
    }

    public void setBorrowedId(String borrowedId) {
        this.borrowedId = borrowedId;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

    @Override
    public String toString() {
        return title + "\t" + genre + "\t" + isBorrowed + "\t" + borrowedId + "\t" + borrowedDate + "\t" + borrowCount + "\t";
    }
}
