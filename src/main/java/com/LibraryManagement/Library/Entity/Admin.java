package com.LibraryManagement.Library.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class Admin {
    @Id
    private int userId;
    private String userName;

    private String address;
    private String institute;
    private long phoneNumber;
    private int coppies;


    public Admin(){

    }

    public Admin(int userId, String userName, String address, String institute, long phoneNumber, int coppies) {
        this.userId = userId;
        this.userName = userName;
        this.address = address;
        this.institute = institute;
        this.phoneNumber = phoneNumber;
        this.coppies = coppies;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCoppies() {
        return coppies;
    }

    public void setCoppies(int coppies) {
        this.coppies = coppies;
    }
}
