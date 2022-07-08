package com.bugtracker.BugService.bugservice.Service;

import com.bugtracker.BugService.bugservice.Entity.Bugs;
import com.bugtracker.BugService.bugservice.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BugService {

    @Autowired
    private Repo repo;
    public Bugs savebug(Bugs bugs) {
        return repo.save(bugs);
    }

    public List<Bugs> getbug() {
        return repo.findAll();
    }

    public void deletebug(String bugid) {
        repo.deleteById(bugid);
    }

    public Bugs updatebug(String bugid, Bugs bugs) {
        Bugs bg = repo.findById(bugid).get();
        bg.setName(bugs.getName());
        bg.setPriority(bugs.getPriority());
        bg.setStatus(bugs.getStatus());

        return repo.save(bg);
    }

    public Bugs getbugbyid(String bugid) {
        return repo.findById(bugid).get();
    }
}
