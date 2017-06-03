package com.prasad.learnspring.SpringOne;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.prasad.learnspring.service.NotificationService;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext con = new AnnotationConfigApplicationContext(Application.class);
		
		WindState ws = new WindState(10, 100);
		System.out.println(ws);
		WindState ws1 = con.getBean(WindState.class);
		System.out.println(ws1);
		
		
		NotificationService notice = con.getBean(NotificationService.class);
		notice.sendNotification("tajane.pr@husky.neu.edu", "pratajane.12@gmail.com", "Let`s learn some spring");
		
		con.close();
	}

}
