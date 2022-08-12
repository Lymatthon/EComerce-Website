package com.mycompany.spring_mvc_project_final.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("sendEmail")
public class MailController {

    @Autowired
    private MailSender mailSender;

    @RequestMapping("create")
    public String doSendEmail() {
        return "sendMail";
    }

    @RequestMapping(value = "sending", method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request) {
        // takes input from e-mail form
//        String recipientAddress = request.getParameter("recipient");
//        String subject = request.getParameter("subject");
//        String message = request.getParameter("message");
        String recipientAddress = "lethitrucly1920@gmail.com";
        String subject = "Test Sending Email";
        String message = "Hello, I am King of 6 Kingdoms.";

        // prints debug info
        System.out.println("To: " + recipientAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);

        // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);

        // sends the e-mail
        mailSender.send(email);

        // forwards to the view named "Result"
        return "index";
    }
}
