package com.bugtracker.userservice.userservice.Controller;

import com.bugtracker.userservice.userservice.Entity.User;
import com.bugtracker.userservice.userservice.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class Usercontroller {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody  User userModel){
        User user = userService.registerUser(userModel);
        log.info("Inside registerUser() method of UserContoller");
        return "User Created Successfully";
    }

    @GetMapping("/login")
    public String login(){
        log.info("Inside registerUser() method of UserContoller");
        return "user logged in...";
    }

    @GetMapping("/list")
    public List<User> list(){
        log.info("Inside registerUser() method of UserContoller");
       return userService.getlist();
    }
}
