package com.prasad.learnspring.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.prasad.learnspring.api.config.SwaggerConfig;
import com.prasad.learnspring.api.config.WebApplicationConfig;

@SpringBootApplication
@Import(value = { SwaggerConfig.class, WebApplicationConfig.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
