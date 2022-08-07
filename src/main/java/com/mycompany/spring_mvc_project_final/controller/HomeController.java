package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.entities.Product;
import com.mycompany.spring_mvc_project_final.entities.RoleEntity;
import com.mycompany.spring_mvc_project_final.enums.Role;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import com.mycompany.spring_mvc_project_final.repository.AccountRepository;
import com.mycompany.spring_mvc_project_final.repository.CategoryRepository;
import com.mycompany.spring_mvc_project_final.service.ProductService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepository cateRpo;

    @Autowired
    AccountRepository accountRepo;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        List<Product> listProduct = productService.getProducts();
        List<Product> listNewestProduct = productService.getNewestProduct();
        double minPrice = listNewestProduct.get(0).getPrice();
        
        for(Product p: listNewestProduct){
            if(p.getPrice()<minPrice){
                minPrice = p.getPrice();
            }
        }
        System.out.println(minPrice);
        
        model.addAttribute("listProduct", listProduct);
        model.addAttribute("listNewestProduct", listNewestProduct);
        model.addAttribute("minPrice", minPrice);
        

        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerView(Model model) {
        Account user = new Account();
        Map<String, String> genderMap = new HashMap<>();
        genderMap.put("male", "Male");
        genderMap.put("female", "Female");
        model.addAttribute("user", user);
        model.addAttribute("genderMap", genderMap);

        return "user/page-register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute(value = "user") Account user) {
        // đưa vào service
        RoleEntity roleE = new RoleEntity();
        roleE.setRole(Role.ROLE_USER);
        Set<RoleEntity> userRoles = new HashSet<>();
        userRoles.add(roleE);
        user.setStatus(UserStatus.ACTIVE);
        user.setUserRoles(userRoles);
        String errMsg = "";
        
        
        if (!user.getPassword()
                .isEmpty() || user.getPassword().equals(user.getConfirmPassword())) {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);
            // add ngày khoi tao
            accountRepo.save(user);
            return "redirect:/login";
        } else {
            errMsg = "Mat khau khong dung, vui long nhap lai!";
            model.addAttribute("errMsg", errMsg);
            return "/register";
        }
    }
    
    
    
    
    

    @RequestMapping(value = "/login")
    public String login() {
        return "user/page-login";
    }

    @RequestMapping(value = "/checkout")
    public String checkout() {
        return "user/page-checkout";
    }

    @RequestMapping(value = "/cart")
    public String cart() {
        return "user/page-cart";
    }

    @RequestMapping("/403")
    public String accessDenied(Model model) {
        return "403Page";
    }
}
