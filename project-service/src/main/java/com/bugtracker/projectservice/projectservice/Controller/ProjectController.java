package com.bugtracker.projectservice.projectservice.Controller;

import com.bugtracker.projectservice.projectservice.Entity.CustomMessage;
import com.bugtracker.projectservice.projectservice.Entity.Project;
import com.bugtracker.projectservice.projectservice.MQConfig;
import com.bugtracker.projectservice.projectservice.Repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        project.setId(seq_service.getseq(INDEX_NAME));
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

    @PostMapping("/addbug/{id}")
    public String publishMessage(@PathVariable("id") int id,@RequestBody CustomMessage message,Project project){
        Long myid = UUID.randomUUID().getMostSignificantBits();
        Project newproject = projectRepo.findById(id).get();
        message.setBugid(myid);
        List<Long> mylist = Collections.singletonList(message.getBugid());
        List<Long> editlist2 = Stream.concat(newproject.getBuglist().stream(),mylist.stream()).collect(Collectors.toList());
        newproject.setBuglist(editlist2);
        message.setName(message.getName());
        message.setPriority(message.getPriority());
        message.setStatus(message.getStatus());
        template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY,message);
        projectRepo.save(newproject);
        return "Done..";
    }
}
