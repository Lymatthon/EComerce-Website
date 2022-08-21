package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.CartDTO;
import com.mycompany.spring_mvc_project_final.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    /**
     *
     * @param model
     * @param session
     * @return
     */

    @GetMapping(value = "/cart")
    public String viewCart(Model model, HttpSession session) {
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        if (cart != null) {
            model.addAttribute("carts", cart.values());
        } else {
            model.addAttribute("carts", null);

        }
        model.addAttribute("cartStats", Utils.cartStats(cart));
        return "user/page-cart";

    }

}
