package com.LibraryManagement.Library.Controller;

import com.LibraryManagement.Library.Entity.Book;
import com.LibraryManagement.Library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

//    BookController(BookService bookService){
//        this.bookService=bookService;
//    }

    @GetMapping("/{bookId}")
    public Book getBookByID(@PathVariable("bookId") int bookId){
        return bookService.getBookById(bookId);
    }

//    @GetMapping("/{bookName}")
//    public Book getBookByName(@PathVariable("bookName") String bookName){
//        return bookService.getBookByName(bookName);
//    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    public String addBook(@RequestBody Book book){
        String msg=bookService.addBook(book);
        return msg;
    }

    @PutMapping
    public String updateBook(@RequestBody Book book){
        String msg=bookService.updateBook(book);
        return msg;
    }

    @DeleteMapping("/{bookId}")
    public String deleteBook(@PathVariable("bookId") int bookId){
        String msg=bookService.deleteBook(bookId);
        return msg;
    }

}
