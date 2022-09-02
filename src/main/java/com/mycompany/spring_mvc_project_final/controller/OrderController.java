/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.OrderDetail;
import com.mycompany.spring_mvc_project_final.entities.OrderEntity;
import com.mycompany.spring_mvc_project_final.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author TriLX
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    

    @Autowired
    OrderService orderS;
    
    @GetMapping(value = "/viewOrderList")
    public String viewOrderList(Model model){
        List<OrderEntity> orders = orderS.getAllOrder();
        for(OrderEntity o : orders){
            List<OrderDetail> p = o.getOrderDetails();
            for(OrderDetail c : p){
                c.getProduct().getProductName();
                c.getColor();
            }
        }
        model.addAttribute("orders", orders);
        return "user/page-view-order";
    }
    
    
}
