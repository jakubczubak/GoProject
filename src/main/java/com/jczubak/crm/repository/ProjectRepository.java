package com.jczubak.crm.repository;

import com.jczubak.crm.entity.Priority;
import com.jczubak.crm.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
