package com.bugtracker.projectservice.projectservice.Controller;

import com.bugtracker.projectservice.projectservice.Entity.CustomMessage;
import com.bugtracker.projectservice.projectservice.Entity.Project;
import com.bugtracker.projectservice.projectservice.MQConfig;
import com.bugtracker.projectservice.projectservice.Repo.ProjectRepo;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.bugtracker.projectservice.projectservice.Entity.Project.INDEX_NAME;

@CrossOrigin(origins = {"http://localhost:3000"})
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

    @PutMapping("/addmembers/{id}")
    public Project addmembers(@PathVariable("id") int id, @RequestBody Project project){
        Project newproject = projectRepo.findById(id).get();
        if(newproject.getMembers() == null){
            newproject.setMembers(project.getMembers());
        }else{
            List<String> memberslist = project.getMembers();
            List<String> finallist = Stream.concat(newproject.getMembers().stream(),memberslist.stream()).collect(Collectors.toList());
            newproject.setMembers(finallist);
        }

        return projectRepo.save(newproject);
    }

    private static final String PROJECT_SERVICE = "project_service";
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/addbug/{id}")
    @CircuitBreaker(name = PROJECT_SERVICE,fallbackMethod = "fallback")
    public String publishMessage(@PathVariable("id") int id,@RequestBody CustomMessage message,Project project){
        String myid = UUID.randomUUID().toString().replace("-","").substring(0,8);
        Project newproject = projectRepo.findById(id).get();
        message.setBugid(myid);
        List<String> mylist = Collections.singletonList(message.getBugid());
        if (newproject.getBuglist() == null){
            List<String> editlist2 = mylist;
            newproject.setBuglist(editlist2);
        }else{
            List<String> editlist2 = Stream.concat(newproject.getBuglist().stream(),mylist.stream()).collect(Collectors.toList());
            newproject.setBuglist(editlist2);
        }
        message.setName(message.getName());
        message.setPriority(message.getPriority());
        message.setStatus(message.getStatus());
        template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY,message);
        projectRepo.save(newproject);
        return "Done..";
    }

    public String fallback(Exception e){
        return "Bug Service is down";
    }
}
