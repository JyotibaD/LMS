package com.LibraryManagement.Library.Service;

import com.LibraryManagement.Library.Entity.Admin;

import java.util.List;

public interface AdminService {
    public Admin getUserByID(int userId);
//    public User getUserByName(String userName);
    public List<Admin> getAllUsers();
    public String addUser(Admin admin);
    public String updateUser(Admin admin);
    public  String deleteUser(int userId);
}
