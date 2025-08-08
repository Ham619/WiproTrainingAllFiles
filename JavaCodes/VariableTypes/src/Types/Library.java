package Types;

public class Library {
    static int booksIssued = 0;

    void issueBook() {
        booksIssued++;
        System.out.println("Books Issued: " + booksIssued);
    }

    public static void main(String[] args) {
        Library l1 = new Library();
        Library l2 = new Library();
        l1.issueBook();
        l2.issueBook();
    }
}
