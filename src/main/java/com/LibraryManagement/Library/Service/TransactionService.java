package com.LibraryManagement.Library.Service;

import com.LibraryManagement.Library.Entity.Book;
import com.LibraryManagement.Library.Entity.Transaction;

import java.util.List;

public interface TransactionService {
    public void borrowBook(Transaction transaction);
    public List<Transaction> getAllBorrowedBooks();
}
