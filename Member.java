import java.util.*;

public class Member {
    private int memberId;
    private String name;
    private List<Integer> issuedBooks = new ArrayList<>();
    private static final int MAX_ISSUES = 3;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public boolean canIssueMore() {
        return issuedBooks.size() < MAX_ISSUES;
    }

    public void issueBook(int bookId) {
        issuedBooks.add(bookId);
    }

    public void returnBook(int bookId) {
        issuedBooks.remove(Integer.valueOf(bookId));
    }

    public boolean hasBook(int bookId) {
        return issuedBooks.contains(bookId);
    }

    public String toString() {
        return memberId + " | " + name +
               " | Issued Books: " + issuedBooks.size();
    }
}
