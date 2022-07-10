package com.bugtracker.userservice.userservice.Controller;

import com.bugtracker.userservice.userservice.Entity.User;
import com.bugtracker.userservice.userservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Usercontroller {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody  User userModel){
        User user = userService.registerUser(userModel);
        return "User Created Successfully";
    }

    @GetMapping("/login")
    public String login(){
        return "user logged in...";
    }

    @GetMapping("/list")
    public List<User> list(){
       return userService.getlist();
    }
}
