package com.LibraryManagement.Library.Service;

import com.LibraryManagement.Library.Entity.Admin;
import com.LibraryManagement.Library.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

//    public UserServiceImpl(UserRepository userRepository){
//        this.userRepository=userRepository;
//    }

    @Override
    public Admin getUserByID(int userId) {
        return adminRepository.findById(userId).get();
    }

//    @Override
//    public User getUserByName(String userName) {
//        return userRepository.getUserByName(userName);
//    }

    @Override
    public List<Admin> getAllUsers() {
        return adminRepository.findAll();
    }

    @Override
    public String addUser(Admin admin) {
        adminRepository.save(admin);
        return "User added";
    }

    @Override
    public String updateUser(Admin admin) {
        adminRepository.save(admin);
        return "User details updated";
    }

    @Override
    public String deleteUser(int userId) {
        adminRepository.deleteById(userId);
        return "User deleted";
    }
}
