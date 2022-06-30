package com.bugtracker.userservice.userservice.Repository;

import com.bugtracker.userservice.userservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
