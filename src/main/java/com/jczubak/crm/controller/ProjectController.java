package com.jczubak.crm.controller;

import com.jczubak.crm.entity.Project;
import com.jczubak.crm.service.ProjectService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/app/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService=projectService;
    }

    @PostMapping(value = "/add", produces = "application/json")
    public String addProject(@RequestBody Project project){
        return projectService.saveProject(project);
    }

    @GetMapping("/list")
        public List<Project> getProjectsList(){
            return projectService.getProjectsList();
        }
    }

