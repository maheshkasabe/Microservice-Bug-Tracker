package com.bugtracker.projectservice.projectservice.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bugtracker.projectservice.projectservice.Entity.Project;

public interface ProjectRepo extends MongoRepository<Project, Integer> {

}
