/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.ProductDetail;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TriLX
 */
@Repository
public interface ProductDetailsRepository extends CrudRepository<ProductDetail, Long> {

    @Query(value = "select * from productdetail\n"
            + " where productId = ?1 and colorId = ?2", nativeQuery = true)
    List<ProductDetail> findPDsByProductIdAndColorId(Long productId, Long colorId);
    
    @Query(value = "select * from productdetail\n"
            + " where productId = ?1 and colorId = ?2 and sizeId = ?3", nativeQuery = true)
    ProductDetail findPDsByProductIdAndColorIdAndSizeId(Long productId, Long colorId, Long sizeId);
    
    @Query(value = "select * from productdetail\n"
            + " where productId = ?1 and sizeId = ?2", nativeQuery = true)
    List<ProductDetail> findPDsByProductIdAndSizeId(Long productId, Long sizeId);
}
