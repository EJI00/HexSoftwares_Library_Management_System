import java.util.*;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add Book 2.Add Member 3.Issue 4.Return 5.View Books 6.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    lib.addBook(new Book(sc.nextInt(), sc.next(), sc.next(), sc.nextInt()));
                    break;
                case 2:
                    lib.addMember(new Member(sc.nextInt(), sc.next()));
                    break;
                case 3:
                    lib.issueBook(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    lib.returnBook(sc.nextInt(), sc.nextInt());
                    break;
                case 5:
                    lib.showBooks();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
