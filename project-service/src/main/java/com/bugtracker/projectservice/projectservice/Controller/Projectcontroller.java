package com.bugtracker.projectservice.projectservice.Controller;

import com.bugtracker.projectservice.projectservice.CustomMessage;
import com.bugtracker.projectservice.projectservice.Entity.Project;
import com.bugtracker.projectservice.projectservice.MQConfig;
import com.bugtracker.projectservice.projectservice.Service.ProjectService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class Projectcontroller {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/")
    public Project saveproject(@RequestBody Project project){
        return projectService.saveproject(project);
    }

    @GetMapping("/")
    public List<Project> getprojects(){
        return projectService.getprojects();
    }

    @GetMapping("/{id}")
    public Project getproject(@PathVariable("id") Long Id){
        return projectService.getproject(Id);
    }

    @DeleteMapping("/{id}")
    public String deleteproject(@PathVariable("id") Long Id){
        projectService.deleteproject(Id);
        return "Project Deleted";
    }

    @PutMapping("/{id}")
    public Project updateproject(@PathVariable("id") Long Id, @RequestBody Project project){
        return projectService.updateproject(Id, project);
    }

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody CustomMessage message){
        message.setName(message.getName());
        message.setPriority(message.getPriority());
        message.setStatus(message.getStatus());
        template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY,message);

        return "Done..";
    }


}
