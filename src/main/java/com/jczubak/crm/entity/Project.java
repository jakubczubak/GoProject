package com.jczubak.crm.entity;

import com.jczubak.crm.service.ProjectService;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;
  private String site;
  @OneToMany
  private List<User> users;
  private double activity;
  private LocalDateTime createdOn;
  private String identifier;

  @PrePersist
  public void prePersist() {
    createdOn = LocalDateTime.now();
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public String getName() {
    return name;
  }
}
