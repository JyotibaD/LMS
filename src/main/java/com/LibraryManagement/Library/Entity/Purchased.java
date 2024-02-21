package com.LibraryManagement.Library.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchased")
public class Purchased {
    @Id
    private int purchasedBookId;
    private String purchasedBookName;
    private int coppies;
    private String purchasedUserName;
    private long purchasedUserPhone;

//    public Purchased(){
//
//    }

    public Purchased(int purchasedBookId, String purchasedBookName, int coppies, String purchasedUserName, long purchasedUserPhone) {
        this.purchasedBookId = purchasedBookId;
        this.purchasedBookName = purchasedBookName;
        this.coppies = coppies;
        this.purchasedUserName = purchasedUserName;
        this.purchasedUserPhone = purchasedUserPhone;
    }

    public int getPurchasedBookId() {
        return purchasedBookId;
    }

    public void setPurchasedBookId(int purchasedBookId) {
        this.purchasedBookId = purchasedBookId;
    }

    public String getPurchasedBookName() {
        return purchasedBookName;
    }

    public void setPurchasedBookName(String purchasedBookName) {
        this.purchasedBookName = purchasedBookName;
    }

    public int getCoppies() {
        return coppies;
    }

    public void setCoppies(int coppies) {
        this.coppies = coppies;
    }

    public String getPurchasedUserName() {
        return purchasedUserName;
    }

    public void setPurchasedUserName(String purchasedUserName) {
        this.purchasedUserName = purchasedUserName;
    }

    public long getPurchasedUserPhone() {
        return purchasedUserPhone;
    }

    public void setPurchasedUserPhone(long purchasedUserPhone) {
        this.purchasedUserPhone = purchasedUserPhone;
    }
}
