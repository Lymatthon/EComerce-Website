package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.CartDTO;
import com.mycompany.spring_mvc_project_final.service.OrderService;
import com.mycompany.spring_mvc_project_final.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TriLX
 */
@RestController
public class APICartController {
    @Autowired
    OrderService orderService;

    @PostMapping(value = "/api/cart")
    public int addToCart(@RequestBody CartDTO params, HttpSession session) {
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        Long productId = params.getProductId();
        if (cart.containsKey(productId)) { // san pham da co trong gio
            CartDTO c = cart.get(productId);
            c.setQuantity(c.getQuantity() + 1);
        } else {// san pham chua co trong gio
            cart.put(productId, params);
        }
        session.setAttribute("cart", cart);

        return Utils.countCart(cart);
    }

    @PutMapping(value = "/api/cart")
    @ResponseStatus(HttpStatus.OK)
    public int updateCartItem(@RequestBody CartDTO params, HttpSession session) {
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        Long productId = params.getProductId();
        if (cart.containsKey(productId)) { // san pham da co trong gio
            CartDTO c = cart.get(productId);
            c.setQuantity(params.getQuantity());
        }
        session.setAttribute("cart", cart);

        return Utils.countCart(cart);

    }

    @DeleteMapping(value = "/api/cart/{productId}")
    public ResponseEntity<Map<String, String>> deleteCartItem(@PathVariable(value = "productId") Long productId, HttpSession session) {
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        if (cart != null && cart.containsKey(productId)) {
            cart.remove(productId);
            session.setAttribute("cart", cart);
        }
        
        return new ResponseEntity<>(Utils.cartStats(cart), HttpStatus.OK);
    }
    
    @PostMapping("/api/pay")
    public HttpStatus pay(HttpSession session){
        if(this.orderService.saveReceipt((Map<Long, CartDTO>) session.getAttribute("cart"), 3L)== true){
            session.removeAttribute("cart");
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

}
