package com.example.monolithic_spring_security.dao;

import java.util.Optional;

import com.example.monolithic_spring_security.entity.AuthUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserDao extends JpaRepository<AuthUser,Integer> {

    Optional<AuthUser> findByauthUsername(String authUserName);
}
