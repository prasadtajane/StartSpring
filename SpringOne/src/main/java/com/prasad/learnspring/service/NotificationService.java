package com.prasad.learnspring.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {
	
	@Autowired
	//this is prototype based injection
	private Email mail;

/*	//this is used in the constructor based injection
	public NotificationService(Email mail) {
		super();
		this.setMail(mail);
	}*/

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
