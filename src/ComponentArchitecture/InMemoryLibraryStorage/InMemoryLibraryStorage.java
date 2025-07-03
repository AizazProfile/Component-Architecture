package ComponentArchitecture.InMemoryLibraryStorage;

import ComponentArchitecture.Interfaces.LibraryStorage;
import ComponentArchitecture.book.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLibraryStorage implements LibraryStorage {
    private List<Book> books = new ArrayList<>();

    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(books);
    }

    @Override
    public boolean delete(String title) {
        return books.removeIf(book -> book.getTitle().equals(title));
    }
}
