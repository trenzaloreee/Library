package library;

import library.exceptions.BookNotFoundException;

public class Main {
    public static void main(String[] args) {
        User user = new User("Ivan");
        Library library = new Library();
        Book book = new Book("myBook", "myAuthor", library);
        library.addBook(book);

        try {
            user.borrowBook(book, library);
            user.printBorrowedBooks();
            user.borrowBook(book, library);
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }

        user.returnBook(book);
        user.printBorrowedBooks();
        user.returnBook(book);
    }
}