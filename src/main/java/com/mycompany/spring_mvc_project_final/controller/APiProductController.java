/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.CartDTO;
import com.mycompany.spring_mvc_project_final.entities.Color;
import com.mycompany.spring_mvc_project_final.service.ColorService;
import com.mycompany.spring_mvc_project_final.service.ProductDetailsService;
import com.mycompany.spring_mvc_project_final.service.SizeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TriLX
 */
@RestController
public class APiProductController {

    @Autowired
    ColorService colorS;

    @Autowired
    SizeService sizeS;

    @Autowired
    ProductDetailsService pDetailsS;

    @PostMapping(value = "/api/getQuantityByColor")
    public int getQuantityByColor(@RequestBody CartDTO params) {
        int sumQuantityByColor = 0;
        Long productId = params.getProductId();
        String color = params.getColor();
        String size = params.getSize();
        if (sizeS.checkIsSize(size)) {
            sumQuantityByColor = pDetailsS.getQuantityByProductIdAndColorAndSize(productId, colorS.getColorIdByColor(color), sizeS.getSizeIdBySize(size));
        } else {
            sumQuantityByColor = pDetailsS.getQuantityByProductIdAndColor(productId, colorS.getColorIdByColor(color));
        }       
        return sumQuantityByColor;
    }
    
    @PostMapping(value = "/api/getQuantityBySize")
    public int getQuantityBySize(@RequestBody CartDTO params) {
        int sumQuantityBySize = 0;
        boolean flag = false;
        Long productId = params.getProductId();
        String color = params.getColor();
        String size = params.getSize();
        List<Color> cList = colorS.getAllColor();
        for (Color c: cList)
            if(c.getColor().equalsIgnoreCase(color)){
                flag = true;
            }               
                        
        if (flag) {
            sumQuantityBySize = pDetailsS.getQuantityByProductIdAndColorAndSize(productId, colorS.getColorIdByColor(color), sizeS.getSizeIdBySize(size));
        } else {
            sumQuantityBySize = pDetailsS.getQuantityByProductIdAndColor(productId, colorS.getColorIdByColor(color));
        }       
        return sumQuantityBySize;
    }
    
    
}
