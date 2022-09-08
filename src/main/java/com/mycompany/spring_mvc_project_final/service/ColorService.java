/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.Color;
import com.mycompany.spring_mvc_project_final.repository.ColorRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author TriLX
 */
@Service
public class ColorService {
    @Autowired
    ColorRepository colorRepo;
    
    @Transactional
    public Color getColorById(Long cId) {
        Optional<Color> color = colorRepo.findById(cId);
        if (color.isPresent()) {
            Color c = color.get();
//            Hibernate.initialize(c.getpDetail());            
            return c;
        }
        return new Color();
    }
    
    @Transactional
    public List<Color> getAllColor() {
        List<Color> colorList = (List<Color>) colorRepo.findAll();
        if (!CollectionUtils.isEmpty(colorList)) {
            for (Color s : colorList) {
//                Hibernate.initialize( s.getpDetail());
            }
            return colorList;
        }

        return new ArrayList<>();

    }
     @Transactional
     public Long getColorIdByColor(String color){
         Long id = colorRepo.findColorIdByColor(color);
         return id;
     }
//     
//     @Transactional
//     public Long getColorIdByColor(String color){
//         Long id = colorRepo.findColorIdByColor(color);
//         return id;
//     }
    
}
