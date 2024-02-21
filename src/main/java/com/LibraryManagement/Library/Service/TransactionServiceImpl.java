package com.LibraryManagement.Library.Service;

import com.LibraryManagement.Library.Entity.Admin;
import com.LibraryManagement.Library.Entity.Book;
import com.LibraryManagement.Library.Entity.Transaction;
import com.LibraryManagement.Library.Repository.AdminRepository;
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

    private final AdminRepository adminRepository ;

    @Autowired
    public TransactionServiceImpl(BookRepository bookRepository, TransactionRepository transactionRepository,AdminRepository adminRepository) {
        this.bookRepository = bookRepository;
        this.transactionRepository = transactionRepository;
        this.adminRepository =adminRepository;
    }

    @Transactional
    public void borrowBook(Transaction transaction) {


        // Retrieve the book from the database
        Book book = bookRepository.findById(transaction.getBook().getBookId())
                .orElseThrow(() -> new IllegalArgumentException("Book not found with ID: " + transaction.getBook().getBookId()));

       Admin user = adminRepository.findById(transaction.getUser().getUserId())
               .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + transaction.getUser().getUserId()));

        // Check if the book is available for borrowing
//        if (!book.isAvailable()) {
////            throw new BookNotAvailableException("Book is not available for borrowing: " + book.getTitle());
//        }

        // Update book status to indicate it's no longer available
        book.setAvailable(false);
        bookRepository.save(book);
        adminRepository.save(transaction.getUser());

        // Create a transaction record for the borrowing activity
        Transaction transactionTemp = new Transaction();
        transactionTemp.setBook(book);
        transactionTemp.setUser(user);
        transactionTemp.setId(transaction.getBook().getBookId());
        transactionTemp.setBorrowedDate(LocalDate.now());
        transactionRepository.save(transactionTemp);
    }

    @Override
    public List<Transaction> getAllBorrowedBooks() {
        return transactionRepository.findAll();
    }

}
