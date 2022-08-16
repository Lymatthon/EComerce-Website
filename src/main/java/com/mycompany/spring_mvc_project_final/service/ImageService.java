/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.Image;
import com.mycompany.spring_mvc_project_final.repository.ImageRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class ImageService {
    @Autowired
    ImageRepository pRepo;
    
    @Transactional
    public List<Image> getImages() {
        List<Image> images = (List<Image>) pRepo.findAll();
        if (!CollectionUtils.isEmpty(images)) {            
            return images;
        }
        return new ArrayList<>();

    }
}
