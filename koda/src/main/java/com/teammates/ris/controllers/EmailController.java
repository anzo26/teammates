package com.teammates.ris.controllers;

import com.teammates.ris.EmailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/sendEmail")
public class EmailController extends EmailSenderService {

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping
    public void posljiEmail(@RequestBody EmailSenderService payload) throws MessagingException {
        String toEmail = payload.getToEmail();
        String subject = payload.getSubject();
        String body = payload.getBody();
        String attachment = payload.getAttachment();
        emailSenderService.sendEmailWithAttachment(toEmail, subject, body, attachment);
    }
}
