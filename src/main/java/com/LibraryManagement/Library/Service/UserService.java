package com.LibraryManagement.Library.Service;

import com.LibraryManagement.Library.Entity.Book;
import com.LibraryManagement.Library.Entity.User;

import java.util.List;

public interface UserService {
    public User getUserByID(int userId);
//    public User getUserByName(String userName);
    public List<User> getAllUsers();
    public String addUser(User user);
    public String updateUser(User user);
    public  String deleteUser(int userId);
}
