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

    public void deletebug(Long id) {
        repo.deleteById(id);
    }

    public Bugs updatebug(Long id, Bugs bugs) {
        Bugs bg = repo.findById(id).get();

        bg.setName(bugs.getName());
        bg.setPriority(bugs.getPriority());
        bg.setStatus(bugs.getStatus());

        return repo.save(bg);
    }

}
