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

    @Query(value = "select sizeId from productdetail\n"
            + " where productId = ?1 and colorId = ?2;", nativeQuery = true)
    List<Long> findSizeIdByProductIdAndColorId(Long productId, Long colorId);
}
