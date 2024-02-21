package com.LibraryManagement.Library.Controller;

import com.LibraryManagement.Library.Entity.Purchased;
import com.LibraryManagement.Library.Service.PurchasedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchasedController {
    @Autowired
    PurchasedService purchasedService;

//    public PurchasedController(PurchasedService purchasedService){
//        this.purchasedService=purchasedService;
//    }

    @GetMapping
    public String getBook(@RequestBody Purchased purchased){
        String msg=purchasedService.purchaseBookById(purchased.getPurchasedBookId(),purchased.getPurchasedUserName(),purchased.getCoppies());
        return msg;
    }
}
