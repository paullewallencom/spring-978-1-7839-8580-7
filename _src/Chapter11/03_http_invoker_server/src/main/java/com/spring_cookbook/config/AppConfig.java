package com.spring_cookbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring_cookbook.service.UserService;
import com.spring_cookbook.service.UserServiceImpl;

@Configuration
@EnableWebMvc
public class AppConfig {
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}
	
	@Bean(name = "/userService")
	public HttpInvokerServiceExporter httpInvokerServiceExporter() {
		HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
		exporter.setService(userService());
		exporter.setServiceInterface(UserService.class);
		return exporter;
	}
}
