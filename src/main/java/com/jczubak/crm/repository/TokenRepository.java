package com.jczubak.crm.repository;

import com.jczubak.crm.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository <Token, Long> {

    Optional<Token> findByValue(String value);
}
