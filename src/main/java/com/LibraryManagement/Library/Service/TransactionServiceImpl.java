package com.LibraryManagement.Library.Service;

import com.LibraryManagement.Library.Entity.Book;
import com.LibraryManagement.Library.Entity.Transaction;
import com.LibraryManagement.Library.Repository.BookRepository;
import com.LibraryManagement.Library.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Service
public class TransactionServiceImpl implements TransactionService{
    private final BookRepository bookRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(BookRepository bookRepository, TransactionRepository transactionRepository) {
        this.bookRepository = bookRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public void borrowBook(Transaction transaction) {
        // Retrieve the book from the database
        Book book = bookRepository.findById(transaction.getBook().getBookId())
                .orElseThrow(() -> new IllegalArgumentException("Book not found with ID: " + transaction.getBook().getBookId()));

        // Check if the book is available for borrowing
//        if (!book.isAvailable()) {
////            throw new BookNotAvailableException("Book is not available for borrowing: " + book.getTitle());
//        }

        // Update book status to indicate it's no longer available
        book.setAvailable(false);
        bookRepository.save(book);

        // Create a transaction record for the borrowing activity
        Transaction transactionTemp = new Transaction();
        transaction.setBook(book);
        transaction.setId(transaction.getBook().getBookId());
        transaction.setBorrowedDate(LocalDate.now());
        transactionRepository.save(transactionTemp);
    }

    @Override
    public List<Transaction> getAllBorrowedBooks() {
        return transactionRepository.findAll();
    }

}
