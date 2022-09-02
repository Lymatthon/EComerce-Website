/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.CartDTO;
import com.mycompany.spring_mvc_project_final.service.ColorService;
import com.mycompany.spring_mvc_project_final.service.ProductDetailsService;
import com.mycompany.spring_mvc_project_final.service.SizeService;
import java.util.ArrayList;
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

    @PostMapping(value = "/api/updateSizeByColor")
    public String updateSizeByColor(@RequestBody CartDTO params) {
        Long productId = params.getProductId();
        String color = params.getColor();
        List<String> sizeList = new ArrayList<>();

        List<Long> sizeIdList = pDetailsS.getSizeByColorIdAndProductId(productId, colorS.getColorIdByColor(color));
        for (Long id : sizeIdList) {
            sizeList.add(sizeS.getSizeBySizeId(id));
        }
        return "size";

    }
}
