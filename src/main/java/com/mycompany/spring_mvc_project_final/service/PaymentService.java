/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.AccountBanking;
import com.mycompany.spring_mvc_project_final.entities.OrderEntity;
import com.mycompany.spring_mvc_project_final.entities.Payment;
import com.mycompany.spring_mvc_project_final.enums.PaymentStatus;
import com.mycompany.spring_mvc_project_final.repository.PaymentRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TriLX
 */
@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepo;

    public void savePayment(Double amount, AccountBanking accountbanking, OrderEntity order, PaymentStatus status) {
        Payment payment = new Payment();
        payment.setAccountBanking(accountbanking);
        payment.setOrder(order);
        payment.setPaymentDate(new Date());
        payment.setStatus(status);
        payment.setAmount(amount);
        
        paymentRepo.save(payment);
    }

}
