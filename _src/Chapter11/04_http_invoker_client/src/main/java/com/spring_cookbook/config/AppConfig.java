package com.spring_cookbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring_cookbook.service.UserService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.spring_cookbook.controllers"})
public class AppConfig {
	
	@Bean(name="userService")
	public HttpInvokerProxyFactoryBean userService() {
		HttpInvokerProxyFactoryBean factory = new HttpInvokerProxyFactoryBean();
		factory.setServiceUrl("http://localhost:8080/http_invoker_server/userService");
		factory.setServiceInterface(UserService.class);
		return factory;
	}
	
}
