package com.bugtracker.userservice.userservice.Service;

import com.bugtracker.userservice.userservice.Entity.User;
import com.bugtracker.userservice.userservice.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        return user;
    }

}
