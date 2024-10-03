package com.example.monolithic_spring_security.controller;

import java.util.List;

import com.example.monolithic_spring_security.entity.Product;
import com.example.monolithic_spring_security.service.Productservice;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    private Productservice productservice;

    //@PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/products")
    public List<Product> getAllProduct()
    {
        return productservice.getAllProduct();
    }

  //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/products/{proId}")
    public Product getAProduct(@PathVariable("proId") int proId)
    {
        return productservice.getAProduct(proId);
    }

   // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product)
    {
        return productservice.addProduct(product);
    }

}
