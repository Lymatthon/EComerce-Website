/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.SizeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TriLX
 */
@Repository
public interface SizeRepository extends CrudRepository<SizeEntity, Long>{
    @Query(value ="select productSize from sizetable where sizeId = ?1", nativeQuery = true)
    String findProductSizeBySizeId(Long sizeId);
    
}
