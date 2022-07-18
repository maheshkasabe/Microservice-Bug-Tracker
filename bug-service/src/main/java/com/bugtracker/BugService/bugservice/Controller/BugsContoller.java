package com.bugtracker.BugService.bugservice.Controller;

import com.bugtracker.BugService.bugservice.Entity.Bugs;
import com.bugtracker.BugService.bugservice.Service.BugService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:3000"})
@Slf4j
@RestController
@RequestMapping("/bugs")
public class BugsContoller {

    @Autowired
    private BugService bugService;

    @PostMapping("/")
    public Bugs savebug(@RequestBody Bugs bugs){
        log.info("Inside savebug() method of bugscontroller");
        return bugService.savebug(bugs);
    }

    @GetMapping("/")
    public List<Bugs> getbug(){
        log.info("Inside getbug() method of bugscontroller");
        return bugService.getbug();
    }

    @GetMapping("/{id}")
    public Bugs getbugbyid(@PathVariable("id") String bugid){
        log.info("Inside getbugbyid() method of bugscontroller");
        return bugService.getbugbyid(bugid);
    }

    @DeleteMapping("/{id}")
    public String deletebug(@PathVariable("id") String bugid){
        log.info("Inside deletebug() method of bugscontroller");
        bugService.deletebug(bugid);
        return "Bug deleted successfully";
    }

    @PutMapping("/{id}")
    public Bugs updatebug(@PathVariable("id") String bugid, @RequestBody Bugs bugs){
        log.info("Inside updatebug() method of bugscontroller");
        return bugService.updatebug(bugid,bugs);
    }
}
