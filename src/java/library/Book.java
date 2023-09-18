package library;

import java.util.List;
import java.util.Objects;

public class Book {
    private String name;
    private String author;
    private boolean available;
    private Library library;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
        available = true;
    }

    public Book(String name, String author, Library library) {      // todo what if book already in library (шаблоны фабрика и адаптер) // garbage collection
        this(name,author);                                          // todo algorithms e.g. binary search
        if (library.addBook(this)) {                                // todo later spring
            this.library = library;
        }
    }

    public void borrowBook() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

//    public void changeAvailability() {
//        available = !available;
//    }


    @Override
    public String toString() {
        return "library.Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", available=" + available +
                '}';
    }


    public String getBook(){
        return name + " " + author;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author);
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Library getLibrary() {
        return library;
    }
}
