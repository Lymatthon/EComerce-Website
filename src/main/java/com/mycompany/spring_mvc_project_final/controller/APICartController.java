package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.CartDTO;
import com.mycompany.spring_mvc_project_final.entities.ProductDetail;
import com.mycompany.spring_mvc_project_final.entities.Promotion;
import com.mycompany.spring_mvc_project_final.service.ColorService;
import com.mycompany.spring_mvc_project_final.service.ProductDetailsService;
import com.mycompany.spring_mvc_project_final.service.PromotionService;
import com.mycompany.spring_mvc_project_final.service.SizeService;
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

    @Autowired
    ProductDetailsService pdService;

    @Autowired
    ColorService colorS;

    @Autowired
    SizeService sizeS;

    @PostMapping(value = "/api/cart")
    public int addToCart(@RequestBody CartDTO params, HttpSession session) {
        // innitial cart
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        // tach ham rieng

        Long newId = getProductDetailsIDByParams(params);

        if (cart.containsKey(newId)) { // san pham da co trong gio
            CartDTO c = cart.get(newId);
            c.setQuantity(c.getQuantity() + params.getQuantity());
        } else {// san pham chua co trong gio
            cart.put(newId, params);
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
//        Long newId = getProductDetailsIDByParams(params);
        Long productId = params.getProductId();
        Long productDId = params.getpDId();
        Long newId = Long.parseLong(String.valueOf(productId) + String.valueOf(productDId));

        if (cart.containsKey(newId)) { // san pham da co trong gio
            CartDTO c = cart.get(newId);
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
                    for (CartDTO c : cart.values()) {
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

    @DeleteMapping(value = "/api/cart/{productId}/{pDId}")
    public ResponseEntity<Map<String, String>> deleteCartItem(@PathVariable(value = "productId") Long productId, @PathVariable(value = "pDId") Long pDId, HttpSession session) {
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        Long newId = Long.parseLong(String.valueOf(productId) + String.valueOf(pDId));

        if (cart != null && cart.containsKey(newId)) {
            cart.remove(newId);
            session.setAttribute("cart", cart);
        }

        return new ResponseEntity<>(Utils.cartStats(cart), HttpStatus.OK);
    }

    private boolean compareDate(Date date1, Date date2, Date dateCompare) {
        return dateCompare.before(date2) || dateCompare.after(date1);
    }

    private Long getProductDetailsIDByParams(CartDTO params) {
        Long productId = params.getProductId();
        Long colorId = colorS.getColorIdByColor(params.getColor());
        Long sizeId = sizeS.getSizeIdBySize(params.getSize());
        ProductDetail pDFound = pdService.getPDsByProductIdAndColorAndSize(productId, colorId, sizeId);
        Long productDId = pDFound.getpDetailId();
        params.setpDId(productDId);
        return Long.parseLong(String.valueOf(productId) + String.valueOf(productDId));
    }

}
