package com.jczubak.crm.service;

import com.jczubak.crm.entity.Role;
import com.jczubak.crm.repository.RoleRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createDefaultRoles(){
        Role roleAdmin = new Role();
        Role roleUser = new Role();

        roleAdmin.setName("ADMIN");
        roleUser.setName("USER");

        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);
    }
}
