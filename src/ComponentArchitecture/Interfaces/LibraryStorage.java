package ComponentArchitecture.Interfaces;

import ComponentArchitecture.book.Book;
import java.util.List;

public interface LibraryStorage {
    void save(Book book);
    List<Book> getAll();
    boolean delete(String title);
}
