/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.OrderEntity;
import com.mycompany.spring_mvc_project_final.service.OrderService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
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
    public String viewOrderList(Model model, HttpSession session) {
        Account currentUser = (Account) session.getAttribute("currentUser");
        List<OrderEntity> orders = orderS.getAllOrder();
        List<OrderEntity> ordersGet = new ArrayList<>();
        
        if (currentUser != null) {
            for (OrderEntity o : orders) {
                if (o.getAccount().getId() == currentUser.getId()) {
                    ordersGet.add(o);
                }
            }
            
        }
        if (!ordersGet.isEmpty() || ordersGet != null) {
            model.addAttribute("orders", ordersGet);
        } else {
            model.addAttribute("orders", null);
        }
        
        return "user/page-view-order";

    }

}
