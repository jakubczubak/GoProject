package com.jczubak.crm.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdOn;
    private String subject;
    @OneToOne
    private Project project;
    private String decription;
    @ManyToOne
    private Status status;
    @ManyToOne
    private Priority priority;
    @OneToMany
    private Set<User> users;
    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now();
    }
}
