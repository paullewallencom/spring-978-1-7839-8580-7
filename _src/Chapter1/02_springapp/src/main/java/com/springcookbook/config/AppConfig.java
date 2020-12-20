package com.springcookbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springcookbook.domain.User;

@Configuration
public class AppConfig {

	@Bean
	public User admin(){
		User u = new User();
		u.setName("Merlin");
		u.setSkill("Magic");
		return u;
	}
}
