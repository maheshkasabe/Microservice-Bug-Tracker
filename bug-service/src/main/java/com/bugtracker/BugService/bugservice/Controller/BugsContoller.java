package com.bugtracker.BugService.bugservice.Controller;

import com.bugtracker.BugService.bugservice.Entity.Bugs;
import com.bugtracker.BugService.bugservice.Service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public String deletebug(@PathVariable("id") Long id){
        bugService.deletebug(id);
        return "Bug {id} delted successfully";
    }

    @PutMapping("/{id}")
    public Bugs updatebug(@PathVariable("id") Long id, @RequestBody Bugs bugs){
        return bugService.updatebug(id,bugs);
    }
}
