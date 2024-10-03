package com.example.monolithic_spring_security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="product_details")
public class Product {

    @Id
    @Column(name="prod_id")
    private int prodId;

    @Column(name="prod_name")
    private String prodName;
    
}
