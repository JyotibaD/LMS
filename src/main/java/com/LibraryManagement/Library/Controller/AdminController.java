package com.LibraryManagement.Library.Controller;

import com.LibraryManagement.Library.Entity.Admin;
import com.LibraryManagement.Library.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class AdminController {
    @Autowired
    AdminService adminService;

//    public  UserController(UserService userService){
//        this.userService=userService;
//    }

    @GetMapping("/{userId}")
    public Admin getUserById(@PathVariable("userId") int userId){
        return adminService.getUserByID(userId);
    }

//    @GetMapping("/userName")
//    public User getUserByName(@PathVariable("userName") String userName){
//        return userService.getUserByName(userName);
//    }

    @GetMapping("/getAll")
    public List<Admin> getAllUser(){
        return adminService.getAllUsers();
    }

    @PostMapping
    public String addUser(@RequestBody Admin admin){
        String msg= adminService.addUser(admin);
        return msg;
    }

    @PutMapping
    public String updateUser(@RequestBody Admin admin){
        String msg= adminService.updateUser(admin);
        return msg;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") int userId){
        String msg= adminService.deleteUser(userId);
        return msg;
    }

}
