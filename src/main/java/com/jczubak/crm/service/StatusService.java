package com.jczubak.crm.service;

import com.jczubak.crm.entity.Status;
import com.jczubak.crm.repository.StatusRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public void addStatus(Status status){
        statusRepository.save(status);
    }

    public List<Status> getStatusList(){
        return statusRepository.findAll();
    }

    public void deleteStatusByID(Long id){
        statusRepository.deleteById(id);
    }
}
