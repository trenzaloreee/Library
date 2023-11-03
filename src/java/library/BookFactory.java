package library;

import library.Book;
import library.Library;
import library.testClasses.Size;

public class BookFactory {
        Library library;

    public BookFactory(Library library) {
        this.library = library;
    }

    public Book buyBook() {         // должен ли метод возвращать что-то? addBook() возвращает boolean
        // если больше больших книг, покупаем маленькую
        if (library.getBigBooks() > library.getSmallBooks()) {
            return new Book("Small Name", "Small Author", library, Size.SMALL);
        } else {
            return new Book("Big Name", "Big Author", library, Size.BIG);
        }
    }
}
