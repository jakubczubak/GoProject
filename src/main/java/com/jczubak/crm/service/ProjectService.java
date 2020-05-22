package com.jczubak.crm.service;

import com.jczubak.crm.entity.Project;
import com.jczubak.crm.repository.ProjectRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }

    public static String removeAccents(String name){
        return StringUtils.stripAccents(name).replace(" ", "-");
    }

    public String saveProject(Project project){
        project.setIdentifier(removeAccents(project.getName()));
        projectRepository.save(project);
        return "success";
    }

    public List<Project> getProjectsList(){
        return projectRepository.findAll();
    }
}
