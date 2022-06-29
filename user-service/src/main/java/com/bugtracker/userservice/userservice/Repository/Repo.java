package com.bugtracker.userservice.userservice.Repository;

import com.bugtracker.userservice.userservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<User, Long> {

}
