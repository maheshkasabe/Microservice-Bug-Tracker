package com.bugtracker.projectservice.projectservice.Controller;

import com.bugtracker.projectservice.projectservice.Entity.Project;
import com.bugtracker.projectservice.projectservice.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class Projectcontroller {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/")
    public Project saveproject(@RequestBody Project project){
        return projectService.saveproject(project);
    }

    @GetMapping("/{id}")
    public Project getproject(@PathVariable("id") Long Id){
        return projectService.findDepartmentById(Id);
    }


}
