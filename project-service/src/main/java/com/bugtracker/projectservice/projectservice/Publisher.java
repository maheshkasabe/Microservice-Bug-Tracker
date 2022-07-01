package com.bugtracker.projectservice.projectservice;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher {

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
