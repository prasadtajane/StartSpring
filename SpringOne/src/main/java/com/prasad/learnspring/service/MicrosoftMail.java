package com.prasad.learnspring.service;
import org.springframework.stereotype.Component;

@Component("microsoft")
public class MicrosoftMail implements Email{

	@Override
	public void sendEmail(String to, String from, String body) {
		System.out.println("This is Microsoft mail notification service...");
		System.out.println("Sender of the mail is    : " + from);
		System.out.println("Recipient of the mail is : " + to);
		System.out.println("Mail body is as follows  : " + body);
		System.out.println("This marks to end of a mail notification.");
		
	}
}
