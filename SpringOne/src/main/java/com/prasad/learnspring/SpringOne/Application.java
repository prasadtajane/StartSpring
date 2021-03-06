package com.prasad.learnspring.SpringOne;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.prasad.learnspring.", "org.prasad.learspring"})
//By Default it scans the package and its sub-packages in which Application (configuration) class is present.
//And if you are using customized beans (using @Bean) then no need to include the CompoinentScan annotation.

public class Application {
	
	@Bean
	public WindState getWind10(){
		return new WindState(50, 500);
	}
}
