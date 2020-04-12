package com.jczubak.crm.controller;

import com.jczubak.crm.entity.Priority;
import com.jczubak.crm.repository.PriorityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private PriorityRepository priorityRepository;

    public PriorityController(PriorityRepository priorityRepository){
        this.priorityRepository=priorityRepository;
    }


    @PostMapping("/add")
    public String addPriority(@RequestBody Priority priority){
        priorityRepository.save(priority);
        return "success";
    }

    @GetMapping("/list")
    public List<Priority> getListOfPriorites(){
        return priorityRepository.findAll();
    }
}
