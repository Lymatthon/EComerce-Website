/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.Category;
import com.mycompany.spring_mvc_project_final.entities.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    Iterable<Product> findProductByCategory(Category cate);
    
    @Query(value ="select * from product p order by p.dateCreate desc limit 12", nativeQuery = true)
    List<Product> findNewestProduct();
    
    @Query(value = "select * from product p\n"
    + " inner join orderDetail o on p.productId = o.productId\n"
    + " order by o.sizeProduct desc", nativeQuery = true)
    List<Product> findBestSellingProduct();
    
    @Query(value = "select * from product where "
    + "match(`description`,productName) "
    + "against(?1)", nativeQuery = true)
    List<Product> search(String keyword);
}
