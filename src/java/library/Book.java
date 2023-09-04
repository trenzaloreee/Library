package library;

public class Book {
    private String name;
    private String author;
    private boolean available;

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
