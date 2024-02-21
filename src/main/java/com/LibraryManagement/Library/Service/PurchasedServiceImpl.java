package com.LibraryManagement.Library.Service;

import com.LibraryManagement.Library.Entity.Book;
import com.LibraryManagement.Library.Entity.Purchased;
import com.LibraryManagement.Library.Entity.User;
import com.LibraryManagement.Library.Repository.BookRepository;
import com.LibraryManagement.Library.Repository.PurchasedRepository;
import com.LibraryManagement.Library.Repository.UserRepository;
import com.LibraryManagement.Library.Service.PurchasedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchasedServiceImpl implements PurchasedService {
    @Autowired
    PurchasedRepository purchasedRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;

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
        User user=new User();
        boolean b1=userRepository.existsById(user.getUserId());
        int c=book.getCoppies();
        if(coppies<=2 && c>1 ){
            if (b){
                if(b1){
                    purchasedRepository.save(new Purchased(bookId,book.getBookName(),c,user.getUserName(),user.getPhoneNumber()));
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
