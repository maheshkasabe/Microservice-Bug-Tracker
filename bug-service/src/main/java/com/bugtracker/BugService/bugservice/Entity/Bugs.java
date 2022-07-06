package com.bugtracker.BugService.bugservice.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bugs {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long bugid;

    private String name;

    private String priority;

    private String status;

    @CreationTimestamp
    private Date created_At;

    @UpdateTimestamp
    private Date updated_At;

}
