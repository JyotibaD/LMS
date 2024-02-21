package com.LibraryManagement.Library.Controller;

import com.LibraryManagement.Library.Entity.Book;
import com.LibraryManagement.Library.Entity.User;
import com.LibraryManagement.Library.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

//    public  UserController(UserService userService){
//        this.userService=userService;
//    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") int userId){
        return userService.getUserByID(userId);
    }

//    @GetMapping("/userName")
//    public User getUserByName(@PathVariable("userName") String userName){
//        return userService.getUserByName(userName);
//    }

    @GetMapping("/getAll")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @PostMapping
    public String addUser(@RequestBody User user){
        String msg=userService.addUser(user);
        return msg;
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        String msg=userService.updateUser(user);
        return msg;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") int userId){
        String msg=userService.deleteUser(userId);
        return msg;
    }

}
