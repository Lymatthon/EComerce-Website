package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.AccountBanking;
import com.mycompany.spring_mvc_project_final.entities.CartDTO;
import com.mycompany.spring_mvc_project_final.entities.Color;
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
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {

    @Autowired
    public MailSender mailsender;

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

    @RequestMapping(value = "/user/getOrderInformation")
    public String processToPay(Model model, HttpSession session) {
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        for (CartDTO c : cart.values()) {
            if (c.getColor() == null) {
                c.setColor("Black");
            }
            if (c.getSize() == null) {
                c.setSize("XS");
            }
        }
        Account user = (Account) session.getAttribute("currentUser");

        model.addAttribute("user", user);
        model.addAttribute("cartStats", Utils.cartStats(cart));
        return "user/page-checkout";
    }

    @GetMapping(value = "/user/processPayment")
    public String getOrderInformation(Model model, HttpSession session) {
        Map<Long, CartDTO> cart = (Map<Long, CartDTO>) session.getAttribute("cart");
        model.addAttribute("cartStats", Utils.cartStats(cart));
        model.addAttribute("paymentDetails", new PaymentDetailsDTO());
        return "user/paymentForm";
    }

    @GetMapping(value = "/user/cancelOrder")
    public String cancelOrder(Model model, HttpSession session) {
        String message = "";
        boolean error = true;
        Account account = (Account) session.getAttribute("currentUser");
        Long userId = account.getId();
        orderService.saveReceipt((Map<Long, CartDTO>) session.getAttribute("cart"), userId, OrderStatus.Cancel);
        session.removeAttribute("cart");
        message = "Your Order has been canceled!";
        model.addAttribute("message", message);
        model.addAttribute("error", error);
        return "user/paymentResult";
    }

    @PostMapping(value = "/user/pay")
    @Transactional
    public String payOrder(HttpSession session, @ModelAttribute(value = "paymentDetails") PaymentDetailsDTO pDetailsDTO, Model model) {
        List<AccountBanking> acountList = accountbankingS.getListAccBanking();
        Account account = (Account) session.getAttribute("currentUser");
        Long userId = account.getId();
        String message = "";
        boolean error = true;

        for (AccountBanking accbanking : acountList) {
            if (checkAccountValid(accbanking, pDetailsDTO)) { // check card information valid or not
                if (accbanking.getBalance() >= Double.parseDouble(pDetailsDTO.getAmount())) {
                    Double balanceAfterPay = accbanking.getBalance() - Double.parseDouble(pDetailsDTO.getAmount());
                    accbanking.setBalance(balanceAfterPay);
                    accountbankingS.saveAccountBanking(accbanking);
                    OrderEntity orderEntity = orderService.saveReceipt((Map<Long, CartDTO>) session.getAttribute("cart"), userId, OrderStatus.Completed);
                    if (orderEntity != null) {
                        paymentService.savePayment(Double.parseDouble(pDetailsDTO.getAmount()), accbanking, orderEntity, PaymentStatus.Completed);
                        error = false;
                        message = "Your order has been successfully placed!";
                        sendEmail("lethitrucly1920@gmail.com", "thebrokebrandon@gmail.com", "Your order has been place successful!", message);
                    }
                } else if (accbanking.getBalance() < Double.parseDouble(pDetailsDTO.getAmount())) {
                    orderService.saveReceipt((Map<Long, CartDTO>) session.getAttribute("cart"), userId, OrderStatus.Failed);
                    error = true;
                    message = "Your account is not enough to pay!";
                }
            }
        }
        if (message.isEmpty()) {
            orderService.saveReceipt((Map<Long, CartDTO>) session.getAttribute("cart"), userId, OrderStatus.Failed);
            message = "Invalid Card!";
        }
        session.removeAttribute("cart");
        model.addAttribute("message", message);
        model.addAttribute("error", error);
        return "user/paymentResult";

    }

    @RequestMapping(value = "/user/successOrder")
    public String viewOrderSuccess() {
        return "user/paymentSuccess";
    }

    public boolean checkAccountValid(AccountBanking accbanking, PaymentDetailsDTO pDetailsDTO) {
        return accbanking.getCustomerName().equalsIgnoreCase(pDetailsDTO.getCustomerName())
                && accbanking.getCardNumber().equalsIgnoreCase(pDetailsDTO.getCardNumber())
                && accbanking.getExpireMonth().equalsIgnoreCase(pDetailsDTO.getExpireMonth())
                && accbanking.getExpireYear().equalsIgnoreCase(pDetailsDTO.getExpireYear())
                && accbanking.getCvvCode().equalsIgnoreCase(pDetailsDTO.getCvvCode());
    }

    public void sendEmail(String from, String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailsender.send(mailMessage);
    }

}
