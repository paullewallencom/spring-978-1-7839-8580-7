package com.spring_cookbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
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
	
	@Bean
	public RmiServiceExporter rmiServiceExporter() {
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		rmiServiceExporter.setServiceName("userService");
		rmiServiceExporter.setService(userService());
		rmiServiceExporter.setServiceInterface(UserService.class);
		return rmiServiceExporter;
	}
}
