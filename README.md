# 📚 Library Management System - Component-Based Architecture

This is a Java-based Library Management System designed using **Component-Based Software Engineering (CBSE)** principles. The project demonstrates modular design through the use of interfaces, components, loose coupling, and dependency injection.

## 💡 Key Features

- Add, list, and delete books
- Switch between **In-Memory** or **File-Based** storage
- Uses **Logger component** for event tracking
- **Extensible architecture** with interface-based design

## 🧱 Component-Based Design Principles Applied

1. **Component**: `LibraryComponent` is a self-contained module that implements `LibraryService`.
2. **Interface vs Implementation**: Interfaces like `LibraryStorage` and `LibraryLogger` allow interchangeable implementations (`InMemoryLibraryStorage`, `FileBasedLibraryStorage`, `ConsoleLogger`).
3. **Loose Coupling**: The system depends only on interfaces, not concrete classes.
4. **High Cohesion**: Each class is focused on a single responsibility (e.g., storage, logging, logic).
5. **Dependency Injection**: All dependencies are injected into `LibraryComponent` via the constructor.
6. **Component Lifecycle**: Clear creation, initialization, use, and cleanup (`scanner.close()`).

## 🛠 Technologies Used

- Java (Console-based)
- Object-Oriented Programming (OOP)
- Java Serialization for file storage

## 📁 Project Structure

ComponentArchitecture/
├── book/ # Book class (data model)
├── Interfaces/ # Logger, Storage, Service interfaces
├── LibraryComponent/ # Main service implementation (component)
├── InMemoryLibraryStorage/ # In-memory storage (volatile)
├── FileBasedLibraryStorage/ # File-based storage using serialization
├── ConsoleLogger/ # Console logging implementation
├── MainApp.java # Main executable class
