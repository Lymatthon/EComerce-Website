/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.Promotion;
import com.mycompany.spring_mvc_project_final.entities.SizeEntity;
import com.mycompany.spring_mvc_project_final.repository.PromotionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
public class PromotionService {
    @Autowired
    PromotionRepository promotionRpo;
    
    @Transactional
    public List<Promotion> getAllPromotion() {
        List<Promotion> promotionList = (List<Promotion>) promotionRpo.findAll();
        if (!CollectionUtils.isEmpty(promotionList)) {
            for (Promotion p : promotionList) {
                Hibernate.initialize( p.getOrders());
            }
            return promotionList;
        }

        return new ArrayList<>();

    }
    
    @Transactional
    public Promotion getPromotionByCode(String code){
        Optional<Promotion> promotion = this.promotionRpo.findPromotionByCode(code);
        if (promotion.isPresent()) {
            Promotion p = promotion.get();
            Hibernate.initialize(p.getOrders());            
            return p;
        }
        return new Promotion();
    }
    
}
