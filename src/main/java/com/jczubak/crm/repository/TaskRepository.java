package com.jczubak.crm.repository;

import com.jczubak.crm.entity.Status;
import com.jczubak.crm.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
