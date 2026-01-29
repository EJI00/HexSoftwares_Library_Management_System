public class Book {
    private int bookId;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;

    public Book(int bookId, String title, String author, int copies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.totalCopies = copies;
        this.availableCopies = copies;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return availableCopies > 0;
    }

    public void issueCopy() {
        availableCopies--;
    }

    public void returnCopy() {
        availableCopies++;
    }
}
