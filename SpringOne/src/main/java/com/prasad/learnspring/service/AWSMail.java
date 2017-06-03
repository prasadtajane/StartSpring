package com.prasad.learnspring.service;
import org.springframework.stereotype.Component;

@Component
public class AWSMail implements Email {

	@Override
	public void sendEmail(String to, String from, String body) {
		System.out.println("Started the AWS mail notification service...");
		System.out.println("This is a message from   : " + from);
		System.out.println("Recipient of the mail is : " + to);
		System.out.println("Mail body is as follows  : " + body);
		System.out.println("This  arks to end of a mail notification.");
	}

}
