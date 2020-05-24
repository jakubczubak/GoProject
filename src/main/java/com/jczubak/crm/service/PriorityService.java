package com.jczubak.crm.service;

import com.jczubak.crm.entity.Priority;
import com.jczubak.crm.repository.PriorityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository projectRepository){
        this.priorityRepository=projectRepository;
    }

    public void addPriority(Priority priority){
        priorityRepository.save(priority);
    }

    public List<Priority> getPriorityList(){
        return priorityRepository.findAll();
    }

    public void deletePriorityByID(Long id){
        priorityRepository.deleteById(id);
    }
}
