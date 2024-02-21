package com.LibraryManagement.Library.Service;

import com.LibraryManagement.Library.Entity.Book;

import java.util.List;

public interface BookService {

    public Book getBookById(int bookId);

//    public Book getBookByName(String bookName);
    public List<Book> getAllBooks();

    public String addBook(Book book);

    public String updateBook(Book book);

    public String deleteBook(int bookId);


}
