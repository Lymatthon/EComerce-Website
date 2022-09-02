/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.AccountBanking;
import com.mycompany.spring_mvc_project_final.repository.AccountBankingRepository;
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
public class AccountBankingService {

    @Autowired
    AccountBankingRepository abRepo;

    @Transactional
    public List<AccountBanking> getListAccBanking() {
        List<AccountBanking> accBankingList = (List<AccountBanking>) abRepo.findAll();
        if (!CollectionUtils.isEmpty(accBankingList)) {
//            for (AccountBanking c : accBankingList) {
//                Hibernate.initialize(c.getPayments());
//            }
            return accBankingList;
        }

        return new ArrayList<>();

    }
    
    public void saveAccountBanking(AccountBanking accBanking){
        abRepo.save(accBanking);
        
    }

}
