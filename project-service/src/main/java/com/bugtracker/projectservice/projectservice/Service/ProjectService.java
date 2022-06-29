package com.bugtracker.projectservice.projectservice.Service;

import com.bugtracker.projectservice.projectservice.Entity.Project;
import com.bugtracker.projectservice.projectservice.Repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    public Project saveproject(Project project) {
        return projectRepo.save(project);
    }

    public Project getproject(Long id) {
        return projectRepo.findById(id).get();
    }

    public void deleteproject(Long id) {
        projectRepo.deleteById(id);
    }

    public List<Project> getprojects() {
        return projectRepo.findAll();
    }

    public Project updateproject(Long id, Project project) {
        Project newproject = projectRepo.findById(id).get();
        newproject.setName(project.getName());
        newproject.setCreator(project.getCreator());

        return projectRepo.save(newproject);
    }
}
