/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.spring_mvc_project_final.utils;

import com.mycompany.spring_mvc_project_final.entities.CartDTO;
import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static int countCart(Map<Long, CartDTO> cart) {
        int quantity = 0;
        if (cart != null) {
            for (CartDTO c : cart.values()) {
                quantity += c.getQuantity();
            }
        }
        return quantity;
    }

    public static Map<String, String> cartStats(Map<Long, CartDTO> cart) {
        Double sum = 0.0;
        int quantity = 0;
        
        if (cart != null) {
            for (CartDTO c : cart.values()) {
                quantity += c.getQuantity();
                sum += c.getQuantity() * c.getPrice();
            }
        }
        Map<String, String> result = new HashMap<>();
        result.put("counter", String.valueOf(quantity));
        result.put("amount", String.valueOf(sum));
        
        return result;
    }
}
