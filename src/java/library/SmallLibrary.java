package library;

import library.exceptions.BookNotFoundException;
import library.testClasses.Size;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmallLibrary {
    private Set books;
    private List users;

    private int smallBooks;
    private int bigBooks;

    public SmallLibrary() {
        books = new HashSet<Book>();
        users = new ArrayList<User>();
    }

    public boolean putBook(Book book) {
        if (book.getSize() == Size.SMALL && books.add(book)) {
            if (book.getLibrary() != null) {
                book.getLibrary().removeBookFromSet(book);
            }
            book.setLibrary(this);
            smallBooks++;

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
