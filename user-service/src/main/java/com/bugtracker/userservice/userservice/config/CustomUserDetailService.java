package com.bugtracker.userservice.userservice.config;

import com.bugtracker.userservice.userservice.Entity.User;
import com.bugtracker.userservice.userservice.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private Repo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(
                    "User Not Found"
            );
        }
        return new CustomUserDetails(user);
    }
}
