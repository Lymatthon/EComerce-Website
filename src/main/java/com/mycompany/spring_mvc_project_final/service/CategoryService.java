/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.Category;
import com.mycompany.spring_mvc_project_final.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository cateRepo;
    
    @Transactional
    public List<Category> getCategories() {
        List<Category> categories = (List<Category>) cateRepo.findAll();
        
        if (!CollectionUtils.isEmpty(categories)) {
            for(Category c: categories){
            Hibernate.initialize(c.getProducts());
        }
            return categories;
        }
        return new ArrayList<>();
    }
    public Category getCategoryById(Long categoryId){
        Optional<Category> cate = cateRepo.findById(categoryId);
        if(cate.isPresent()){
            return cate.get();
        }
        return new Category();
        
    }
}
