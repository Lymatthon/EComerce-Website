/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.ProductDetail;
import com.mycompany.spring_mvc_project_final.repository.ProductDetailsRepository;
import java.util.ArrayList;
import java.util.List;
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

    @Transactional
    public int getQuantityByProductIdAndColor(Long productId, Long colorId) {
        List<ProductDetail> pDList = pDetailsRepo.findPDsByProductIdAndColorId(productId, colorId);
        int sum = 0;
        if (!pDList.isEmpty() || pDList != null) {
            for (ProductDetail pd : pDList) {
                sum += pd.getQuantity();

            }
        }
        return sum;
    }

    @Transactional
    public int getQuantityByProductIdAndColorAndSize(Long productId, Long colorId, Long sizeId) {
        ProductDetail pD = pDetailsRepo.findPDsByProductIdAndColorIdAndSizeId(productId, colorId, sizeId);
        int sum = 0;
        if (pD != null) {
            sum = pD.getQuantity();
        }
        return sum;
    }

    @Transactional
    public int countQuantityOfProduct(List<ProductDetail> listPDs) {
        int sum = 0;
        if (listPDs != null || !listPDs.isEmpty()) {
            for (ProductDetail pd : listPDs) {
                sum += pd.getQuantity();
            }
        }
        return sum;
    }

    @Transactional
    public int getQuantityByProductIdAndSize(Long productId, Long sizeId) {
        List<ProductDetail> pDList = pDetailsRepo.findPDsByProductIdAndSizeId(productId, sizeId);
        int sum = 0;
        if (!pDList.isEmpty() || pDList != null) {
            for (ProductDetail pd : pDList) {
                sum += pd.getQuantity();
            }
        }
        return sum;
    }
    
    @Transactional
    public ProductDetail getPDsByProductIdAndColorAndSize(Long productId, Long colorId, Long sizeId) {
        return pDetailsRepo.findPDsByProductIdAndColorIdAndSizeId(productId, colorId, sizeId);
        
    }
}
