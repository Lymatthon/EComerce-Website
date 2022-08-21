/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.RoleEntity;
import com.mycompany.spring_mvc_project_final.enums.Role;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import com.mycompany.spring_mvc_project_final.repository.AccountRepository;
import com.mycompany.spring_mvc_project_final.repository.RoleRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TriLX
 */
@Service
public class AccountService {

    @Autowired
    AccountRepository accountRpo;
    
    @Autowired
    RoleRepository roleRepo;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public Account getAccount(Long userId) {
        Optional<Account> account = accountRpo.findById(userId);
        if (account.isPresent()) {
            return account.get();
        }
        return new Account();
    }

    @Transactional
    public boolean addUser(Account account) {
        try {
            String encryptedPassword = passwordEncoder.encode(account.getPassword());
            List<RoleEntity> userRoles = new ArrayList<>();
            userRoles.add(roleRepo.getOne(1L));
            
            account.setPassword(encryptedPassword);
            account.setStatus(UserStatus.ACTIVE);
            account.setUserRoles(userRoles);
            accountRpo.save(account);
        } catch (Exception e) {
        }

        return false;
    }
}
