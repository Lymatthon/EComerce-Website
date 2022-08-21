/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.CartDTO;
import com.mycompany.spring_mvc_project_final.entities.OrderDetail;
import com.mycompany.spring_mvc_project_final.entities.OrderEntity;
import com.mycompany.spring_mvc_project_final.repository.OrderDetailsRepository;
import com.mycompany.spring_mvc_project_final.repository.OrderRepository;
import com.mycompany.spring_mvc_project_final.utils.Utils;
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TriLX
 */
@Service
public class OrderService {

    @Autowired
    AccountService userService;

    @Autowired
    ProductService prodService;

    @Autowired
    OrderDetailsRepository oDetailsRepo;

    @Autowired
    OrderRepository orderRepo;
//    
//    @Autowired
//    LocalSessionFactoryBean sessionFactory;

    @Transactional(propagation = Propagation.MANDATORY)
    public boolean saveReceipt(Map<Long, CartDTO> cart, Long userId) {
        try {
            if (cart != null) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
                Account userAcount = userService.getAccount(userId);
                OrderEntity order = new OrderEntity();
                order.setAccount(userAcount);
                order.setDateCreate(new Date());
//        order.setPromotions(promotions); can them promotion get tu form
//        order.setStatus
                Map<String, String> stats = Utils.cartStats(cart);
                order.setAmount(Double.parseDouble(stats.get("amount")));
                orderRepo.save(order);

                for (CartDTO c : cart.values()) {
                    OrderDetail d = new OrderDetail();
                    d.setOrder(order);
                    d.setProduct(this.prodService.getProduct(c.getProductId()));
                    d.setPrice(c.getPrice());
                    d.setQuantity(c.getQuantity());
                    oDetailsRepo.save(d); // can bo sung them neu thieu
                }
                return true;
            }
            return false;

        } catch (HibernateException ex) {
            ex.printStackTrace();

        }
        return false;
    }
}
