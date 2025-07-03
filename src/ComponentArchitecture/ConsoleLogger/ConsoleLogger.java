package ComponentArchitecture.ConsoleLogger;

import ComponentArchitecture.Interfaces.LibraryLogger;

public class ConsoleLogger implements LibraryLogger {
    @Override
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
