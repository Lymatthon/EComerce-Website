/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.service;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.CartDTO;
import com.mycompany.spring_mvc_project_final.entities.OrderDTO;
import com.mycompany.spring_mvc_project_final.entities.OrderDetail;
import com.mycompany.spring_mvc_project_final.entities.OrderEntity;
import com.mycompany.spring_mvc_project_final.entities.Promotion;
import com.mycompany.spring_mvc_project_final.enums.OrderStatus;
import com.mycompany.spring_mvc_project_final.repository.OrderDetailsRepository;
import com.mycompany.spring_mvc_project_final.repository.OrderRepository;
import com.mycompany.spring_mvc_project_final.utils.Utils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    
    @Autowired
    PromotionService proS;
 
    @Transactional(propagation = Propagation.REQUIRED)
    public OrderEntity saveReceipt(Map<Long, CartDTO> cart, Long userId, OrderStatus status, OrderDTO orderDTO) {
        try {
            if (cart != null) {
                Account userAcount = userService.getAccount(userId);
                List<Promotion> listCoupon = new ArrayList<>();
                String codePromotion = "";
                int discount = 0;
                for(CartDTO product : cart.values()){
                    codePromotion = product.getCoupon();
                    discount = product.getDiscount();
                }
                
                listCoupon.add(proS.getPromotionByCode(codePromotion));                
                
                OrderEntity order = new OrderEntity();
                order.setAccount(userAcount);
                order.setDateCreate(new Date());
                order.setStatus(status);
                order.setDiscount(discount);
                order.setCustomerName(orderDTO.getCustomerName());
                order.setCode(codePromotion);
                order.setAddress(orderDTO.getAddress());
                order.setGender(orderDTO.getGender());
                order.setPhone(orderDTO.getPhone());
                order.setPromotions(listCoupon);
                
                Map<String, String> stats = Utils.cartStats(cart);
                order.setAmount(Double.parseDouble(stats.get("amount")));
                orderRepo.save(order);
                
                

                for (CartDTO c : cart.values()) {
                    OrderDetail d = new OrderDetail();
                    d.setOrder(order);
                    d.setProduct(this.prodService.getProduct(c.getProductId()));
                    d.setPrice(c.getPrice());
                    d.setQuantity(c.getQuantity());
                    d.setColor(c.getColor());
                    d.setSize(c.getSize());
                    oDetailsRepo.save(d); // can bo sung them neu thieu
                }
                return order;
            }
            return null;

        } catch (HibernateException ex) {
            ex.printStackTrace();

        }
        return null;
    }
}
