package ComponentArchitecture.book;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getDetails() {
        return "Title: " + title + ", Author: " + author;
    }

    public String getTitle() {
        return title;
    }
}
