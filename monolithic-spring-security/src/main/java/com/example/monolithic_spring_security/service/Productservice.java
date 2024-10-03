package com.example.monolithic_spring_security.service;

import java.util.List;

import com.example.monolithic_spring_security.dao.ProductDao;
import com.example.monolithic_spring_security.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Productservice {

    @Autowired
    private ProductDao productDao;

    public List<Product> getAllProduct()
    {
        return productDao.findAll();
    }


    public Product getAProduct(int proId)
    {
        return productDao.findById(proId).get();
    }


    public Product addProduct(Product product)
    {
        return productDao.saveAndFlush(product);
    }



    
}
