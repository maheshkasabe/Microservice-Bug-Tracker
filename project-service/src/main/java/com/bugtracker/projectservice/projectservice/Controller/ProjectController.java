package com.bugtracker.projectservice.projectservice.Controller;

import com.bugtracker.projectservice.projectservice.Entity.CustomMessage;
import com.bugtracker.projectservice.projectservice.Entity.Project;
import com.bugtracker.projectservice.projectservice.MQConfig;
import com.bugtracker.projectservice.projectservice.Repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

import static com.bugtracker.projectservice.projectservice.Entity.Project.INDEX_NAME;

@RestController()
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private com.bugtracker.projectservice.projectservice.Service.seq_service seq_service;

    @PostMapping("/")
    public Project saveProject(@RequestBody Project project){
        project.setId(INDEX_NAME);
        return projectRepo.save(project);
    }

    @GetMapping("/")
    public List<Project> getprojects(){
        return projectRepo.findAll();
    }

    @GetMapping("/{id}")
    public Project getproject(@PathVariable("id") int id){
        return projectRepo.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public String deleteproject(@PathVariable("id") int id){
        projectRepo.deleteById(id);
        return "Project Deleted";
    }

    @PutMapping("/{id}")
    public Project updateproject(@PathVariable("id") int id, @RequestBody Project project){
        Project newproject = projectRepo.findById(id).get();
        newproject.setName(project.getName());
        newproject.setCreator(project.getCreator());
        newproject.setMembers(project.getMembers());
        newproject.setBuglist(project.getBuglist());
        return projectRepo.save(newproject);
    }

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{id}/addbug")
    public String publishMessage(@PathVariable("id") int id,@RequestBody CustomMessage message,Project project){
        Project newproject = projectRepo.findById(id).get();
        newproject.setBuglist(project.getBuglist());
        message.setId(message.getId());
        message.setName(message.getName());
        message.setPriority(message.getPriority());
        message.setStatus(message.getStatus());
        template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY,message);
        projectRepo.save(newproject);
        return "Done..";
    }
}
