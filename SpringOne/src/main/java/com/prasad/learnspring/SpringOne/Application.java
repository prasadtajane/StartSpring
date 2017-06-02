package com.prasad.learnspring.SpringOne;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.prasad.learnspring.", "org.prasad.learspring"})
//By Default it scans the package and its sub-packages in which Application (configuration) class is present

public class Application {
	
	@Bean
	public WindState getWind10(){
		return new WindState(50, 500);
	}
}
