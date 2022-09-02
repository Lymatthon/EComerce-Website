/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.repository;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByEmailLikeAndStatusLike(String email,
            UserStatus status);
    List<Account> findByEmail(String email);
    
    @Modifying
    @Query(value = "UPDATE account SET address = ?1, customerName = ?2, gender = ?3, phone = ?4 WHERE id = ?5", nativeQuery = true)
    void updateAccount(String address, String username, String gender, String phone, Long id);
}
