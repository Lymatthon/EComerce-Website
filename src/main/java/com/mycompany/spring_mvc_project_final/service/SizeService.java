/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.SizeEntity;
import com.mycompany.spring_mvc_project_final.repository.SizeRepository;
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
public class SizeService {

    @Autowired
    SizeRepository sizeRepo;

    @Transactional
    public List<SizeEntity> getAllSize() {
        List<SizeEntity> sizeList = (List<SizeEntity>) sizeRepo.findAll();
        if (!CollectionUtils.isEmpty(sizeList)) {
            for (SizeEntity s : sizeList) {
                Hibernate.initialize(s.getpDetail());
            }
            return sizeList;
        }

        return new ArrayList<>();

    }

    @Transactional
    public String getSizeBySizeId(Long pId) {
        String size = sizeRepo.findProductSizeBySizeId(pId);
        return size;
    }

    @Transactional
    public Long getSizeIdBySize(String size) {
        Long id = sizeRepo.findSizeIdBySize(size);
        return id;
    }

    @Transactional
    public boolean checkIsSize(String size) {
        List<SizeEntity> list = (List<SizeEntity>) sizeRepo.findAll();
        for (SizeEntity s : list) {
            if (s.getSize().equalsIgnoreCase(size)) {
                return true;
            }
        }
        return false;
    }

}
