package com.bugtracker.projectservice.projectservice.Service;

import com.bugtracker.projectservice.projectservice.Entity.Project;
import com.bugtracker.projectservice.projectservice.Repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public Project saveproject(Project project) {
        return projectRepo.save(project);
    }

    public Project findDepartmentById(Long Id) {
        return projectRepo.findById(Id).get();
    }
}
