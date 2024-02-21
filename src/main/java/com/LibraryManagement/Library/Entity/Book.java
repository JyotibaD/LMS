package com.LibraryManagement.Library.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book {
    @Id
    private int bookId;
    private String bookName;
    private int coppies;
    private String bookAuthor;

    private boolean available;

    public Book() {

    }

    public Book(int bookId, String bookName, int coppies, String bookAuthor) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.coppies = coppies;
        this.bookAuthor = bookAuthor;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getCoppies() {
        return coppies;
    }

    public void setCoppies(int coppies) {
        this.coppies = coppies;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setAvailable(boolean b) {
        available=b;
    }

    public boolean isAvailable() {
        return available;
    }
}
