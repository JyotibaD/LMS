package com.LibraryManagement.Library.Controller;

import com.LibraryManagement.Library.Entity.Transaction;
import com.LibraryManagement.Library.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowBook")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService=transactionService;
    }

    @PostMapping
    public String borrowBook(@RequestBody Transaction transaction){
        transactionService.borrowBook(transaction);
        return "Thanks for the borrowing book..";
    }

    @GetMapping("/getAllBorrowedBooks")
    public List<Transaction> getAllBorrowedBooks(){
        return transactionService.getAllBorrowedBooks();
    }
}
