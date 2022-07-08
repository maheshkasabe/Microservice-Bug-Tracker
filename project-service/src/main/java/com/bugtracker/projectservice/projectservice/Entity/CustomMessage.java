package com.bugtracker.projectservice.projectservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomMessage {

    @Id
    private String bugid;

    private String name;

    private String priority;

    private String status;

}
