package ComponentArchitecture.LibraryComponent;

import ComponentArchitecture.Interfaces.LibraryLogger;
import ComponentArchitecture.Interfaces.LibraryService;
import ComponentArchitecture.Interfaces.LibraryStorage;
import ComponentArchitecture.book.Book;

import java.util.List;

public class LibraryComponent implements LibraryService {
    private LibraryStorage storage;
    private LibraryLogger logger;

    public LibraryComponent(LibraryStorage storage, LibraryLogger logger) {
        this.storage = storage;
        this.logger = logger;
    }

    @Override
    public void addBook(Book book) {
        storage.save(book);
        logger.log("Added book: " + book.getDetails());
    }

    @Override
    public List<Book> listBooks() {
        logger.log("Listing all books");
        return storage.getAll();
    }

    @Override
    public boolean removeBook(String title) {
        boolean removed = storage.delete(title);
        if (removed) {
            logger.log("Removed book with title: " + title);
        } else {
            logger.log("Failed to remove book with title: " + title);
        }
        return removed;
    }
}
