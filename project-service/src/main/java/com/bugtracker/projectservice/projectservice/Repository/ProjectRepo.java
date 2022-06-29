package com.bugtracker.projectservice.projectservice.Repository;

import com.bugtracker.projectservice.projectservice.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {

}
