package com.mycompany.spring_mvc_project_final.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailController {
    
    @Autowired
    public MailSender mailsender;

//    @RequestMapping(method = RequestMethod.GET)
//    public String showEmailsPage() {
//        return "user/emails";
//    }

    @RequestMapping(value = "/mail/send", method = RequestMethod.POST)
    public String createMail() {
        sendEmail("lethitrucly1920@gmail.com", "thebrokebrandon@gmail.com", "Test Email Spring", "This is content!!!!!!!!!!!!!");

        return "index";
    }
    public void sendEmail(String from, String to, String subject, String content){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailsender.send(mailMessage);
    }
}
