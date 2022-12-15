package com.teammates.ris;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.io.File;


@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    private String toEmail;
    private String subject;
    private String body;
    private String attachment;

    public void sendEmailWithAttachment(String toEmail, String subject, String body, String attachment){

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom("matija.krsnik2112@gmail.com");
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body);

            FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
            javaMailSender.send(mimeMessage);

            System.out.println("Mail with attachment sent successfully");
        }catch (MessagingException e){
            e.printStackTrace();
        }
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
