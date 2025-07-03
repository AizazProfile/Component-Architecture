package ComponentArchitecture.FileBasedLibraryStorage;

import ComponentArchitecture.Interfaces.LibraryStorage;
import ComponentArchitecture.book.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileBasedLibraryStorage implements LibraryStorage {
    private static final String FILE_NAME = "library_data.ser";

    @Override
    public void save(Book book) {
        List<Book> books = getAll();
        books.add(book);
        saveToFile(books);
    }

    @Override
    public List<Book> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to read from storage", e);
        }
    }

    @Override
    public boolean delete(String title) {
        List<Book> books = getAll();
        boolean removed = books.removeIf(book -> book.getTitle().equals(title));
        if (removed) {
            saveToFile(books);
        }
        return removed;
    }

    private void saveToFile(List<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save to storage", e);
        }
    }
}
