package com.prasad.learnspring.SpringOne;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext con = new AnnotationConfigApplicationContext(Application.class);
		
		WindState ws = new WindState(10, 100);
		System.out.println(ws);
		
		WindState ws1 = con.getBean(WindState.class);
		System.out.println(ws1);
		
		System.out.println(ws == ws1);
		
	}

}
