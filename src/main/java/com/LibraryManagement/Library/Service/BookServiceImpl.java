package com.LibraryManagement.Library.Service;

import com.LibraryManagement.Library.Entity.Book;
import com.LibraryManagement.Library.Repository.BookRepository;
import com.LibraryManagement.Library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

//    public BookServiceImpl(BookRepository bookRepository){
//        this.bookRepository = bookRepository;
//    }

    @Override
    public Book getBookById(int bookId) {

        Book book= bookRepository.findById(bookId).get();
        return book;
    }

//    @Override
//    public Book getBookByName(String bookName) {
//        return bookRepository.getBookByName(bookName);
//    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public String addBook(Book book) {
        bookRepository.save(book);
        return "Book added successfully";
    }

    @Override
    public String updateBook(Book book) {
        bookRepository.save(book);
        return "Book updated successfully";
    }

    @Override
    public String deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
        return "Book deleted successfully";
    }
}
