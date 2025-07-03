package ComponentArchitecture;

import ComponentArchitecture.ConsoleLogger.ConsoleLogger;
import ComponentArchitecture.InMemoryLibraryStorage.InMemoryLibraryStorage;
import ComponentArchitecture.Interfaces.LibraryLogger;
import ComponentArchitecture.Interfaces.LibraryService;
import ComponentArchitecture.Interfaces.LibraryStorage;
import ComponentArchitecture.LibraryComponent.LibraryComponent;
import ComponentArchitecture.book.Book;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        LibraryStorage storage = new InMemoryLibraryStorage();
        LibraryLogger logger = new ConsoleLogger();
        LibraryService library = new LibraryComponent(storage, logger);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a new book");
            System.out.println("2. List all books");
            System.out.println("3. Delete a book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Add a new book (title, author):");
                    String title = scanner.nextLine();
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;

                case 2:
                    System.out.println("Books in Library:");
                    for (Book book : library.listBooks()) {
                        System.out.println(book.getDetails());
                    }
                    break;

                case 3:
                    System.out.println("Enter title of the book to delete:");
                    String titleToDelete = scanner.nextLine();
                    if (library.removeBook(titleToDelete)) {
                        System.out.println("Book deleted successfully");
                    } else {
                        System.out.println("Book not found");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
