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
import java.util.Optional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Transactional
    public List<Product> getProducts() {
        List<Product> products = (List<Product>) productRepo.findAll();
        if (!CollectionUtils.isEmpty(products)) {
            for (Product c : products) {
                Hibernate.initialize( c.getpDetails());
                Hibernate.initialize( c.getOrderDetails());
                Hibernate.initialize( c.getImages());
            }
            return products;
        }

        return new ArrayList<>();

    }

    @Transactional
    public List<Product> getProductsByCategory(Category category) {
        List<Product> products = (List<Product>) productRepo.findProductByCategory(category);
        if (!CollectionUtils.isEmpty(products)) {
            for (Product c : products) {
                Hibernate.initialize(c.getpDetails());
                Hibernate.initialize(c.getOrderDetails());
                Hibernate.initialize( c.getImages());
            }
            return products;
        }
        return new ArrayList<>();
    }

    @Transactional
    public List<Product> getNewestProduct() {
        List<Product> products = (List<Product>) productRepo.findNewestProduct();
        if (!CollectionUtils.isEmpty(products)) {
            for (Product c : products) {
//                Hibernate.initialize(c.getpDetails());
//                Hibernate.initialize(c.getOrderDetails());
                Hibernate.initialize( c.getImages());
            }
            return products;
        }

        return new ArrayList<>();
    }

    @Transactional
    public List<Product> getBestSellingProduct() {
        List<Product> products = (List<Product>) productRepo.findBestSellingProduct();
        if (!CollectionUtils.isEmpty(products)) {
            for (Product c : products) {
                Hibernate.initialize(c.getpDetails());
                Hibernate.initialize(c.getOrderDetails());
                Hibernate.initialize( c.getImages());
            }
            return products;
        }

        return new ArrayList<>();
    }
    
    @Transactional
    public Product getProduct(Long pId) {
        Optional<Product> product = productRepo.findById(pId);
        if (product.isPresent()) {
            Product p = product.get();
            Hibernate.initialize(p.getImages());
            Hibernate.initialize(p.getOrderDetails());
            Hibernate.initialize(p.getpDetails());
            
            return p;
        }
        return new Product();
    }
    
    @Transactional
    public List<Product> getProductBySearch(String keyword) {
        List<Product> products = (List<Product>) productRepo.search(keyword);
        if (!CollectionUtils.isEmpty(products)) {
            for (Product c : products) {
                Hibernate.initialize(c.getpDetails());
                Hibernate.initialize(c.getOrderDetails());
                Hibernate.initialize( c.getImages());
            }
            return products;
        }

        return new ArrayList<>();
    }
    
    

}
