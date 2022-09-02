package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.CartDTO;
import com.mycompany.spring_mvc_project_final.entities.Promotion;
import com.mycompany.spring_mvc_project_final.service.OrderService;
import com.mycompany.spring_mvc_project_final.service.PromotionService;
import com.mycompany.spring_mvc_project_final.utils.Utils;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    PromotionService promotionS;

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

    @PostMapping(value = "/api/cartFull")
    public int addToCartFull(@RequestBody CartDTO params, HttpSession session) {
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        Long productId = params.getProductId();
        if (cart.containsKey(productId)) { // san pham da co trong gio
            CartDTO c = cart.get(productId);
            c.setQuantity(c.getQuantity() + params.getQuantity());
        } else {// san pham chua co trong gio
            cart.put(productId, params);
        }
        session.setAttribute("cart", cart);

        return Utils.countCart(cart);
    }
    
    @PutMapping(value = "/api/updateQuantity")
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

    @PutMapping(value = "/api/updateCouponCart")
    public HttpStatus updateCouponCart(@RequestBody CartDTO params, HttpSession session) {
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        List<Promotion> promotionList = promotionS.getAllPromotion();

        if (cart == null) {
            cart = new HashMap<>();
        }
        String couponGet = params.getCoupon();
        Date currentDate = new Date();
        
        
        for (Promotion p : promotionList) {
                        
            if (p.getCode().equalsIgnoreCase(couponGet) && p.getPromotionType().equals("Order")) {
                if (compareDate(p.getStartDate(), p.getEndDate(), currentDate)) {
                    for(CartDTO c : cart.values()){
                        c.setCoupon(couponGet);
                        c.setDiscount(p.getDiscount());
                    }
                    return HttpStatus.OK;                    
                }
            }
        }
        session.setAttribute("cart", cart);

        return HttpStatus.BAD_REQUEST;
    }

    @PutMapping(value = "/api/updateColor")
    public HttpStatus updateColorCart(@RequestBody CartDTO params, HttpSession session) {
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        Long productId = params.getProductId();
        if (cart.containsKey(productId)) { // san pham da co trong gio
            CartDTO c = cart.get(productId);
            c.setColor(params.getColor());
            return HttpStatus.OK;
        }
        session.setAttribute("cart", cart);

        return HttpStatus.BAD_REQUEST;
    }

    @PutMapping(value = "/api/updateSize")
    public HttpStatus updateSizeCart(@RequestBody CartDTO params, HttpSession session) {
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        Long productId = params.getProductId();
        if (cart.containsKey(productId)) { // san pham da co trong gio
            CartDTO c = cart.get(productId);
            c.setSize(params.getSize());
            return HttpStatus.OK;
        }
        session.setAttribute("cart", cart);

        return HttpStatus.BAD_REQUEST;
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

//    @PostMapping("/api/pay")
//    public HttpStatus pay(HttpSession session) {
//        Account account = (Account) session.getAttribute("currentUser");
//        Long userId = account.getId();
//        if (this.orderService.saveReceipt((Map<Long, CartDTO>) session.getAttribute("cart"), userId) == true) {
//            session.removeAttribute("cart");//luu cart thanh order => xoa
//            return HttpStatus.OK;
//        }
//        return HttpStatus.BAD_REQUEST;
//    }

    private boolean compareDate(Date date1, Date date2, Date dateCompare) {
        return dateCompare.before(date2) || dateCompare.after(date1);
    }

}
