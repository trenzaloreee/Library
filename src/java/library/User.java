package library;

import library.exceptions.BookNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List borrowedBooks;

    public User(String name) {
        this.name = name;
        borrowedBooks = new ArrayList();
    }

    public void borrowBook(Book book, Library library) throws BookNotFoundException{
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.borrowBook();
            library.removeBookFromSet(book);
            System.out.println("User " + name + " has borrowed " + " " + book.getName() + " by " + book.getAuthor());
        } else {
            throw new BookNotFoundException("This book is currently borrowed");
//            System.out.println("This book is currently borrowed");
        }
    }



    public void returnBook(Book book){
        if (borrowedBooks.remove(book)) {
            book.returnBook();
            System.out.println("The book was returned");
        } else {
            System.out.println("There's nothing to return");
        }
    }

    public void printBorrowedBooks(){
        System.out.println("This person has borrowed the following books: " + borrowedBooks);
    }

    public String getName() {
        return name;
    }
}
