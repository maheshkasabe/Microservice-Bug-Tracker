package com.bugtracker.projectservice.projectservice.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

@Document(collection = "project")
public class Project {

    @Transient
    public static final String INDEX_NAME = "db_sequence";

    @Id
    private int id;

    private String name;

    private String creator;

    private List<String> members;

    private List<String> buglist;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date timestamp = new Date();

}
