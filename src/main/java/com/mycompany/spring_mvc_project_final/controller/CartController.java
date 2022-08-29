package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.AccountBanking;
import com.mycompany.spring_mvc_project_final.entities.CartDTO;
import com.mycompany.spring_mvc_project_final.entities.Color;
import com.mycompany.spring_mvc_project_final.entities.OrderDTO;
import com.mycompany.spring_mvc_project_final.entities.OrderEntity;
import com.mycompany.spring_mvc_project_final.entities.PaymentDetailsDTO;
import com.mycompany.spring_mvc_project_final.entities.SizeEntity;
import com.mycompany.spring_mvc_project_final.enums.OrderStatus;
import com.mycompany.spring_mvc_project_final.enums.PaymentStatus;
import com.mycompany.spring_mvc_project_final.service.AccountBankingService;
import com.mycompany.spring_mvc_project_final.service.ColorService;
import com.mycompany.spring_mvc_project_final.service.OrderService;
import com.mycompany.spring_mvc_project_final.service.PaymentService;
import com.mycompany.spring_mvc_project_final.service.SizeService;
import com.mycompany.spring_mvc_project_final.utils.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @Autowired
    SizeService sizeS;

    @Autowired
    ColorService colorS;

    @Autowired
    AccountBankingService accountbankingS;

    @Autowired
    OrderService orderService;
    
    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "/cart")
    public String viewCart(Model model, HttpSession session) {
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        List<SizeEntity> listSize = sizeS.getAllSize();
        List<Color> listColor = colorS.getAllColor();
        if (cart != null) {
            model.addAttribute("carts", cart.values());

        } else {
            model.addAttribute("carts", null);

        }
        model.addAttribute("cartStats", Utils.cartStats(cart));
        model.addAttribute("listSize", listSize);
        model.addAttribute("listColor", listColor);
        return "user/page-cart";

    }

    @GetMapping(value = "/clearCart")
    public String clearCart(HttpSession session) {
        session.removeAttribute("cart");
        return "user/page-cart";

    }

    @GetMapping(value = "/cart/getOrderInformation")
    public String processToPay(Model model, HttpSession session) {
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        Map<String, String> genderMap = new HashMap<>();
        genderMap.put("male", "Male");
        genderMap.put("female", "Female");
        model.addAttribute("genderMap", genderMap);
        model.addAttribute("cartStats", Utils.cartStats(cart));
        model.addAttribute("order", new OrderDTO());
        return "user/page-checkout";
    }
    
    @PostMapping(value = "/cart/processPayment")
    public String getOrderInformation(Model model, HttpSession session, @ModelAttribute(value = "order") OrderDTO orderDTO) {
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        OrderDTO order = (OrderDTO) session.getAttribute("order");
        if (order != null) {
            session.removeAttribute("order");
        }
        session.setAttribute("order", orderDTO);
        model.addAttribute("cartStats", Utils.cartStats(cart));
        model.addAttribute("paymentDetails", new PaymentDetailsDTO());
        return "user/paymentForm";
    }

    @PostMapping(value = "/cart/pay")
    @Transactional
    public String payOrder(HttpSession session, @ModelAttribute(value = "paymentDetails") PaymentDetailsDTO pDetailsDTO, Model model) {
        List<AccountBanking> acountList = accountbankingS.getListAccBanking();
        String message = "";
        boolean error = true;

        for (AccountBanking accbanking : acountList) {
            if (checkAccountValid(accbanking, pDetailsDTO)) { // check card information valid or not
                if (accbanking.getBalance() >= Double.parseDouble(pDetailsDTO.getAmount())) {
                    Double balanceAfterPay = accbanking.getBalance() - Double.parseDouble(pDetailsDTO.getAmount());
                    accbanking.setBalance(balanceAfterPay);
                    accountbankingS.saveAccountBanking(accbanking);
                    OrderDTO order = (OrderDTO) session.getAttribute("order");
                    Account account = (Account) session.getAttribute("currentUser");
                    Long userId = account.getId();
                    OrderEntity orderEntity = orderService.saveReceipt((Map<Long, CartDTO>) session.getAttribute("cart"), userId, OrderStatus.Completed, order);
                    if (orderEntity != null) {
                        paymentService.savePayment(Double.parseDouble(pDetailsDTO.getAmount()), accbanking, orderEntity, PaymentStatus.Completed);
                        session.removeAttribute("cart");
                        session.removeAttribute("order");
                    }
                    error = false;
                    message = "Your order has been successfully placed";
                } else if (accbanking.getBalance() < Double.parseDouble(pDetailsDTO.getAmount())) {
                    error = true;
                    message = "Your account is not enough to pay!";
                }
            } else if (!checkAccountValid(accbanking, pDetailsDTO)) {
                error = true;
                message = "Invalid Card!";
            }
        }

        model.addAttribute("message", message);
        model.addAttribute("error", error);
        return "user/paymentResult";

    }

    public boolean checkAccountValid(AccountBanking accbanking, PaymentDetailsDTO pDetailsDTO) {
        return accbanking.getCustomerName().equalsIgnoreCase(pDetailsDTO.getCustomerName())
                && accbanking.getCardNumber().equalsIgnoreCase(pDetailsDTO.getCardNumber())
                && accbanking.getExpireMonth().equalsIgnoreCase(pDetailsDTO.getExpireMonth())
                && accbanking.getExpireYear().equalsIgnoreCase(pDetailsDTO.getExpireYear())
                && accbanking.getCvvCode().equalsIgnoreCase(pDetailsDTO.getCvvCode());
    }

}
