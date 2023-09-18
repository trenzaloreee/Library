package library;

import library.exceptions.BookNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private Set books;
    private List users;

    public Library() {
        books = new HashSet<Book>();
        users = new ArrayList<User>();
    }

    public boolean addBook(Book book) {
        if (books.add(book)) {
            book.getLibrary().removeBookFromSet(book);
            book.setLibrary(this);
            return true;
        }

        return false;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void borrowBook(User user, String title, String author) {
       Book book = new Book(title,author);
       try {
           user.borrowBook(book, this);
       } catch (BookNotFoundException e) {
           e.printStackTrace();
       }
    }


    public void removeBookFromSet(Book book){
        books.remove(book);
    }

    public void returnBook (User user, String bookTitle, String author){
        books.add(new Book(bookTitle, author));
    }

//    public Book getBookByName(String name) throws BookNotFoundException {
//        for (Book b : books) {
//
//        }
//
//
//        List list = books.stream().filter(b -> name.equals(((Book)b).getName())).collect(Collectors.toList());
//    } не работает из-за метода getBook()

}

