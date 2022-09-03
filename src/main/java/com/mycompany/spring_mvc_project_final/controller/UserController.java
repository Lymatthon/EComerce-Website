/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.Account;
import com.mycompany.spring_mvc_project_final.repository.AccountRepository;
import com.mycompany.spring_mvc_project_final.service.AccountService;
import com.mycompany.spring_mvc_project_final.service.UserDetailsServiceImpl;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    AccountRepository accountRpo;

    @Autowired
    AccountService accountService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserDetailsServiceImpl userService;

    @RequestMapping("/home")
    public String viewHome(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.toString();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }

        model.addAttribute("message", "Hello User: " + username);
        return "user/home";
    }

    @RequestMapping("/viewprofile")
    public String viewUserProfile(Model model, HttpSession session) {
        Account account = (Account) session.getAttribute("currentUser");
        model.addAttribute("account", account);
        return "user/page-user-account";
    }

    @PostMapping("/updateprofile")
    public String updateUserProfile(Model model, @ModelAttribute(value = "account") Account account, HttpSession session) {
        Long id = account.getId();
        Account accountAfterUpdate = new Account();
        accountService.updateUser(account);

        accountAfterUpdate = accountService.getUserById(id);

        session.removeAttribute("currentUser");
        session.setAttribute("currentUser", accountAfterUpdate);

        model.addAttribute("account", accountAfterUpdate);
        return "user/page-user-account";
    }

    @GetMapping("/formChangePassword")
    public String showFormChangePassword() {
        return "user/page-change-password";
    }

    @PostMapping("/changePassword")
    public String changePassword(Model model, @RequestParam("oldPw") String oldPw, @RequestParam("newPw") String newPw, @RequestParam("verifyPw") String verifyPw,
            HttpSession session) {
        Account account = (Account) session.getAttribute("currentUser");
        String pass = account.getPassword();
        String message = "";
        boolean flag = false;
        if (passwordEncoder.matches(oldPw, pass)) {
            if (newPw.equals(verifyPw)) {
                account.setPassword(passwordEncoder.encode(newPw));
                accountRpo.save(account);
                flag = true;
                message = "Your password was change successfully!";
            }
        } else {
            message = "Your password was wrong, please try again!";
        }
        model.addAttribute("flag", flag);
        model.addAttribute("message", message);
        return "user/page-change-password";
    }

}
