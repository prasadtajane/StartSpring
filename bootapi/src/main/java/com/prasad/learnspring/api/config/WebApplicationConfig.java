package com.prasad.learnspring.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebApplicationConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
    //Cors are added to allow other applications to access your api
    public void addCorsMapping(CorsRegistry reg)	{
    	reg.addMapping("/api/**")
    		.allowedOrigins("http://mocker.egen.io")
    		.allowedMethods("GET", "DELETE", "PATCH", "POST", "PUT")
    		.allowedHeaders("header1", "header2", "header3")
    		.exposedHeaders("header1", "header2");
    }
}