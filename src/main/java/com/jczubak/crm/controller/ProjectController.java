package com.jczubak.crm.controller;

import com.jczubak.crm.entity.Project;
import com.jczubak.crm.repository.ProjectRepository;
import lombok.Data;
import lombok.Lombok;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }

    @RequestMapping(value = "/add", produces = "application/json")
    public String addProject(@RequestBody Project project){
        project.setIdentifier();
        projectRepository.save(project);
        return "success";
    }

    @GetMapping("/lsit")
        public List<Project> getProjectsList(){
            return projectRepository.findAll();
        }
    }

