package com.example.monolithic_spring_security.dao;

import com.example.monolithic_spring_security.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{
    
}
