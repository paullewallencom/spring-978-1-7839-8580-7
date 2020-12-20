package com.springcookbook.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcookbook.config.AppConfig;
import com.springcookbook.domain.User;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(AppConfig.class);

		User admin = (User) springContext.getBean("admin");

		System.out.println("admin name: " + admin.getName());
		System.out.println("admin skill: " + admin.getSkill());

		springContext.close();		
	}
}
