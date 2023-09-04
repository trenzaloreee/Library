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

    public Book getBookByName(String name) throws BookNotFoundException {
        for (Book b : books) {

        }


        List list = books.stream().filter(b -> name.equals(((Book)b).getName())).collect(Collectors.toList());
    }

}
