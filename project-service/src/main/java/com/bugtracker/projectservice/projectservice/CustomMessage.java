package com.bugtracker.projectservice.projectservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomMessage {

    private String name;

    private String priority;

    private String status;

}
