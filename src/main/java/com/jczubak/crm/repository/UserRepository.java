package com.jczubak.crm.repository;

import com.jczubak.crm.entity.Task;
import com.jczubak.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByLogin(String login);
}
