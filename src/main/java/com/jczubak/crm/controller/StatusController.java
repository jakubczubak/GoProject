package com.jczubak.crm.controller;

import com.jczubak.crm.entity.Status;
import com.jczubak.crm.repository.StatusRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/status")
public class StatusController {

    private StatusRepository statusRepository;

    public StatusController(StatusRepository statusRepository){
        this.statusRepository=statusRepository;
    }

    @RequestMapping(value = "/add", produces = "application/json")
    public String addStatus(@RequestBody Status status){
       statusRepository.save(status);
        return "success";
    }

    @GetMapping("/list")
    public List<Status> getStatusList(){
        return statusRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStatusByID(@PathVariable Long id){
        statusRepository.deleteById(id);
        return "success";
    }
}
