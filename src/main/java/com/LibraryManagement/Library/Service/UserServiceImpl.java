package com.LibraryManagement.Library.Service;

import com.LibraryManagement.Library.Entity.User;
import com.LibraryManagement.Library.Repository.UserRepository;
import com.LibraryManagement.Library.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

//    public UserServiceImpl(UserRepository userRepository){
//        this.userRepository=userRepository;
//    }

    @Override
    public User getUserByID(int userId) {
        return userRepository.findById(userId).get();
    }

//    @Override
//    public User getUserByName(String userName) {
//        return userRepository.getUserByName(userName);
//    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String addUser(User user) {
        userRepository.save(user);
        return "User added";
    }

    @Override
    public String updateUser(User user) {
        userRepository.save(user);
        return "User details updated";
    }

    @Override
    public String deleteUser(int userId) {
        userRepository.deleteById(userId);
        return "User deleted";
    }
}
