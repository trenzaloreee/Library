package library;

import library.exceptions.BookNotFoundException;
import library.testClasses.LibraryInterface;
import library.testClasses.Size;

import java.util.*;

public class Library implements LibraryInterface {
    private Set books;
    private List users;

    private int smallBooks;     // todo
    private int bigBooks;          // todo change value in addBook

    public Library() {
        books = new HashSet<Book>();
        users = new ArrayList<User>();
    }

    public boolean addBook(Book book) {
        if (books.add(book)) {
            if (book.getLibrary() != null) {
                book.getLibrary().removeBookFromSet(book);
            }
            book.setLibrary(this);
            if (book.getSize() == Size.BIG) {
                bigBooks++;
            } else {
                smallBooks++;
            }
            return true;
        }
        return false;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void borrowBook(User user, String title, String author, Size size) {
        Book book = new Book(title, author, size);
        try {
            user.borrowBook(book, this);
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void removeBookFromSet(Book book) {
        books.remove(book);
    }

    public void returnBook(User user, String bookTitle, String author, Size size) {
        books.add(new Book(bookTitle, author, size));
    }


    public int getSmallBooks() {
        return smallBooks;
    }

    public int getBigBooks() {
        return bigBooks;
    }

    public void printSet() {
        System.out.println(books);
    }
}

