import java.util.*;
import java.time.temporal.ChronoUnit;

public class Library {
    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, Member> members = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
        System.out.println("Book added successfully.");
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
        System.out.println("Member added successfully.");
    }

    public void issueBook(int bookId, int memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null) {
            System.out.println("Invalid book or member ID.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book not available.");
            return;
        }

        if (!member.canIssueMore()) {
            System.out.println("Issue limit exceeded.");
            return;
        }

        book.issueCopy();
        member.issueBook(bookId);
        transactions.add(new Transaction(bookId, memberId));

        System.out.println("Book issued successfully.");
    }

    public void returnBook(int bookId, int memberId) {
        Book book = books.get(bookId);
        Member member = members.get(memberId);

        if (book == null || member == null || !member.hasBook(bookId)) {
            System.out.println("Invalid return.");
            return;
        }

        Transaction record = null;
        for (Transaction t : transactions) {
            if (t.bookId == bookId && t.memberId == memberId) {
                record = t;
                break;
            }
        }

        long days = ChronoUnit.DAYS.between(record.issueDate, java.time.LocalDate.now());
        if (days > 14) {
            System.out.println("Late return fine: ₹" + (days - 14) * 5);
        }

        book.returnCopy();
        member.returnBook(bookId);
        transactions.remove(record);

        System.out.println("Book returned successfully.");
    }

    public void showBooks() {
        books.values().forEach(System.out::println);
    }

    public void showMembers() {
        members.values().forEach(System.out::println);
    }
}
