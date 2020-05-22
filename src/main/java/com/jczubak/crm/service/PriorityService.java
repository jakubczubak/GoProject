package com.jczubak.crm.service;

import com.jczubak.crm.repository.PriorityRepository;
import com.jczubak.crm.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository projectRepository){
        this.priorityRepository=projectRepository;
    }
}
