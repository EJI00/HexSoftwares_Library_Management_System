import java.time.LocalDate;

public class Transaction {
    int bookId;
    int memberId;
    LocalDate issueDate;

    public Transaction(int bookId, int memberId) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = LocalDate.now();
    }
}
