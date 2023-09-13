package library;

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


}
