/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.ProductDetail;
import com.mycompany.spring_mvc_project_final.repository.ProductDetailsRepository;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author TriLX
 */
@Service
public class ProductDetailsService {

    @Autowired
    private ProductDetailsRepository pDetailsRepo;

    @Transactional
    public List<ProductDetail> getProductDetailsList() {
        List<ProductDetail> productDetailsList = (List<ProductDetail>) pDetailsRepo.findAll();
        if (!CollectionUtils.isEmpty(productDetailsList)) {
            return productDetailsList;
        }

        return new ArrayList<>();

    }

}
