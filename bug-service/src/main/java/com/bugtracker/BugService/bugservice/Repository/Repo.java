package com.bugtracker.BugService.bugservice.Repository;

import com.bugtracker.BugService.bugservice.Entity.Bugs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Bugs, String> {

}
