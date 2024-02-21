package com.LibraryManagement.Library.Service;

import com.LibraryManagement.Library.Entity.Admin;
import com.LibraryManagement.Library.Entity.Book;
import com.LibraryManagement.Library.Entity.Purchased;
import com.LibraryManagement.Library.Repository.BookRepository;
import com.LibraryManagement.Library.Repository.PurchasedRepository;
import com.LibraryManagement.Library.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchasedServiceImpl implements PurchasedService {
    @Autowired
    PurchasedRepository purchasedRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AdminRepository adminRepository;

//    public PurchasedServiceImpl(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//    public PurchasedServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//    public PurchasedServiceImpl(PurchasedRepository purchasedRepository){
//        this.purchasedRepository=purchasedRepository;
//    }
    @Override
    public String purchaseBookById(int bookId,String userName,int coppies) {
        boolean b=bookRepository.existsById(bookId);
        Book book=bookRepository.findById(bookId).get();
        Admin admin =new Admin();
        boolean b1= adminRepository.existsById(admin.getUserId());
        int c=book.getCoppies();
        if(coppies<=2 && c>1 ){
            if (b){
                if(b1){
                    purchasedRepository.save(new Purchased(bookId,book.getBookName(),c, admin.getUserName(), admin.getPhoneNumber()));
                    return "Happy reading...";

                }
                else {
                    return "Please register first..";
                }
            }
            else {
                return "Book is not available..";
            }
        }
        else {
            return "Book not available..";
        }

    }
}
