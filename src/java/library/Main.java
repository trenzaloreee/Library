package library;

import library.exceptions.BookNotFoundException;
import library.testClasses.AdapterLibrary;
import library.testClasses.LibraryInterface;
import library.testClasses.Size;

public class Main {
    public static void main(String[] args) {
        User user = new User("Ivan");
        Library library = new AdapterLibrary();
        BookFactory myFactory = new BookFactory(library);

        Book book = new Book("myBook", "myAuthor", library, Size.SMALL);
        Book book1 = new Book("myBook1", "myAuthor1", library, Size.SMALL);
        Book book2 = new Book("myBook2", "myAuthor2", library, Size.BIG);
        myFactory.buyBook();
        library.printSet();
        myFactory.buyBook();
        library.printSet();
        myFactory.buyBook();
        library.printSet();
        myFactory.buyBook();
        library.printSet();
//        library.addBook(book);
//        library.addBook(book1);
//        library.addBook(book2);



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