package com.bugtracker.userservice.userservice.Service;

import com.bugtracker.userservice.userservice.Entity.User;
import com.bugtracker.userservice.userservice.Repository.Repo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private Repo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User userModel) {
        User user = new User();
        user.setUsername(userModel.getUsername());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setRole(userModel.getRole());
        repo.save(user);
        log.info("Inside registerUser() method of UserService");
        return user;
    }

    public List<User> getlist() {
        log.info("Inside getlist() method of UserService");
        return repo.findAll();
    }
}
