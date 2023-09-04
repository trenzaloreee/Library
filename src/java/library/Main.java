package library;

public class Main {
    public static void main(String[] args) {
        User user = new User("Ivan");
        Book book = new Book("myBook", "myAuthor");

        user.borrowBook(book);
        user.printBorrowedBooks();
        user.borrowBook(book);

        user.returnBook(book);
        user.printBorrowedBooks();
        user.returnBook(book);
    }

}