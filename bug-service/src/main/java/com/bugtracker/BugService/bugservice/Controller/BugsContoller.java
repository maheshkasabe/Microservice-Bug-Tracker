package com.bugtracker.BugService.bugservice.Controller;

import com.bugtracker.BugService.bugservice.Entity.Bugs;
import com.bugtracker.BugService.bugservice.Service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/bugs")
public class BugsContoller {

    @Autowired
    private BugService bugService;

    @PostMapping("/")
    public Bugs savebug(@RequestBody Bugs bugs){
        return bugService.savebug(bugs);
    }

    @GetMapping("/")
    public List<Bugs> getbug(){
        return bugService.getbug();
    }

    @GetMapping("/{id}")
    public Bugs getbugbyid(@PathVariable("id") String bugid){
        return bugService.getbugbyid(bugid);
    }

    @DeleteMapping("/{id}")
    public String deletebug(@PathVariable("id") String bugid){
        bugService.deletebug(bugid);
        return "Bug deleted successfully";
    }

    @PutMapping("/{id}")
    public Bugs updatebug(@PathVariable("id") String bugid, @RequestBody Bugs bugs){
        return bugService.updatebug(bugid,bugs);
    }
}
