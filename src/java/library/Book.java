package library;

import library.testClasses.LibraryInterface;
import library.testClasses.Size;

import java.util.Objects;

public class Book {
    private String name;
    private String author;
    private boolean available;
    private LibraryInterface library;

    private Size size;  // todo BIG SMALL

    public Book(String name, String author, Size size) {
        this.name = name;
        this.author = author;
        available = true;
        this.size = size;
    }

    public Book(String name, String author, Library library, Size size) {      // todo what if book already in library (шаблоны фабрика и адаптер) // garbage collection
        this(name,author, size);                                          // todo algorithms e.g. binary search (test program for binary search HW + adapter)
        if (library.addBook(this)) {                                // todo later spring -> sql
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
                ", size=" + size +
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

    public void setLibrary(LibraryInterface library) {
        this.library = library;
    }

    public LibraryInterface getLibrary() {
        return library;
    }


    public Size getSize() {
        return size;
    }

}
