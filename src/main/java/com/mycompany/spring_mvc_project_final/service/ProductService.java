/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.Category;
import com.mycompany.spring_mvc_project_final.entities.Product;
import com.mycompany.spring_mvc_project_final.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public List<Product> getProducts() {
        List<Product> products = (List<Product>) productRepo.findAll();
        if (!CollectionUtils.isEmpty(products)) {
            for (Product c : products) {
                Hibernate.initialize(c.getpDetails());
                Hibernate.initialize(c.getOrderDetails());
            }
            return products;
        }

        return new ArrayList<>();

    }

    public List<Product> getProductsByCategory(Category category) {
        List<Product> products = (List<Product>) productRepo.findProductByCategory(category);
        if (!CollectionUtils.isEmpty(products)) {
            for (Product c : products) {
                Hibernate.initialize(c.getpDetails());
                Hibernate.initialize(c.getOrderDetails());
            }
            return products;
        }
        return new ArrayList<>();
    }

    public List<Product> getNewestProduct() {
        List<Product> products = (List<Product>) productRepo.findNewestProduct();
        if (!CollectionUtils.isEmpty(products)) {
            for (Product c : products) {
                Hibernate.initialize(c.getpDetails());
                Hibernate.initialize(c.getOrderDetails());
            }
            return products;
        }

        return new ArrayList<>();
    }

}
