package com.teammates.ris;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RisApplication {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(RisApplication.class, args);
	}

	/*
	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail() throws MessagingException {
		emailSenderService.sendEmailWithAttachment("matija.krsnik2112@gmail.com", "Hello World", "Test", "C:\\Users\\matij\\Downloads\\test.pdf");
	}*/

}
