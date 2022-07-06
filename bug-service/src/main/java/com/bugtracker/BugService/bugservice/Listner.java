package com.bugtracker.BugService.bugservice;

import com.bugtracker.BugService.bugservice.Entity.Bugs;
import com.bugtracker.BugService.bugservice.Repository.Repo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Listner {

    @Autowired
    private Repo repo;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listner(Bugs bugs){
        repo.save(bugs);
    }
}
