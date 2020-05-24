package com.jczubak.crm.controller;

import com.jczubak.crm.entity.Status;
import com.jczubak.crm.repository.StatusRepository;
import com.jczubak.crm.service.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/app/status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @RequestMapping(value = "/add", produces = "application/json")
    public String addStatus(@RequestBody Status status){
       statusService.addStatus(status);
        return "success";
    }

    @GetMapping("/list")
    public List<Status> getStatusList(){
        return statusService.getStatusList();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStatusByID(@PathVariable Long id){
        statusService.deleteStatusByID(id);
        return "success";
    }
}
