package com.bugtracker.BugService.bugservice.Service;

import com.bugtracker.BugService.bugservice.Entity.Bugs;
import com.bugtracker.BugService.bugservice.Repository.Repo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BugService {

    @Autowired
    private Repo repo;
    public Bugs savebug(Bugs bugs) {
        log.info("Inside savebug() method of BugService");
        return repo.save(bugs);
    }

    public List<Bugs> getbug() {
        log.info("Inside getbug() method of BugService");
        return repo.findAll();
    }

    public void deletebug(String bugid) {
        log.info("Inside deletebug() method of BugService");
        repo.deleteById(bugid);
    }

    public Bugs updatebug(String bugid, Bugs bugs) {
        Bugs bg = repo.findById(bugid).get();
        bg.setName(bugs.getName());
        bg.setPriority(bugs.getPriority());
        bg.setStatus(bugs.getStatus());
        log.info("Inside updatebug() method of BugService");
        return repo.save(bg);
    }

    public Bugs getbugbyid(String bugid) {
        log.info("Inside getbugbyid() method of BugService");
        return repo.findById(bugid).get();
    }
}
