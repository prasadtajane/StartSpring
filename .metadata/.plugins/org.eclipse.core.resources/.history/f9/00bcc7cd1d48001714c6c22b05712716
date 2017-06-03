package com.prasad.learnspring.service;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {
	
	private Email mail;

	public NotificationService(Email mail) {
		super();
		this.setMail(mail);
	}

	public Email getMail() {
		return mail;
	}

	public void setMail(Email mail) {
		this.mail = mail;
	}

	public void sendNotification(String to, String from, String body){
		mail.sendEmail(to, from, body);
	}
	
}
