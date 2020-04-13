package com.jczubak.crm.controller;

import com.jczubak.crm.entity.Priority;
import com.jczubak.crm.repository.PriorityRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/priority")
public class PriorityController {

    private PriorityRepository priorityRepository;

    public PriorityController(PriorityRepository priorityRepository){
        this.priorityRepository=priorityRepository;
    }


    @RequestMapping(value = "/add", produces = "application/json")
    public String addPriority(@RequestBody Priority priority){
        priorityRepository.save(priority);
        return "success";
    }

}