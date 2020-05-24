package com.jczubak.crm.controller;

import com.jczubak.crm.entity.Priority;
import com.jczubak.crm.service.PriorityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/app/priority")
public class PriorityController {

    private final PriorityService priorityService;

    public PriorityController(PriorityService priorityService){
        this.priorityService=priorityService;
    }


    @RequestMapping(value = "/add", produces = "application/json")
    public String addPriority(@RequestBody Priority priority){
        priorityService.addPriority(priority);
        return "success";
    }

    @GetMapping("/list")
    public List<Priority> getPriorityList(){
        return priorityService.getPriorityList();
    }

    @DeleteMapping("/delete/{id}")
    public String deletePriorityByID(@PathVariable Long id){
        priorityService.deletePriorityByID(id);
        return "success";
    }

}
