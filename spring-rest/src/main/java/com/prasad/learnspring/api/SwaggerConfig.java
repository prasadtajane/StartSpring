package com.prasad.learnspring.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api()	{
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}
	
	private ApiInfo apiInfo()	{
		//public Contact(String name, String url, String email)
		Contact contact = new Contact("Admin", "http://egen.io", "admin@egen.com");
		
		//(title, description, version, termsOfServiceUrl, new Contact(contactName, "", ""), license, licenseUrl
		ApiInfo apiInfo = 
				new ApiInfo(
				"Weather Forecast",
				"Monthly weather details",
				"1.0.0",
				"ToSU",
				contact, 
				"Egen solutions",
				"http://egen.io");
		
		return apiInfo;
	}
}
