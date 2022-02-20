package com.jakil.email;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class EmailSenderApplication {

	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(EmailSenderApplication.class, args);

		System.out.println("Email sender application is started");
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		service.sendSimpleMail("syedjakil09@gmail.com", "This is the body", "This is the subject");
		service.sendEmailWithAttachment("syedjakil09@gmail.com", "This is the body", "This is the subject",
				"D:\\Study\\Notes\\GIT Notes.txt");
	}
}
