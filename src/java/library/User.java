package library;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List borrowedBooks;

    public User(String name) {
        this.name = name;
        borrowedBooks = new ArrayList();
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.borrowBook();
        }else {
            System.out.println("This book is currently borrowed");
        }
    }

    public void borrowBook(String name){
//        try {
//            library.getBookByName(name);
//        }
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
