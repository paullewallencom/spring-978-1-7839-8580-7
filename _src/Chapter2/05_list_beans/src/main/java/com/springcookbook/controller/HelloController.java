package com.springcookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	 @Autowired
	 private ApplicationContext applicationContext;
	 
	
	@RequestMapping("hi")
	@ResponseBody
	public String hi() {
		
		String[] beans = applicationContext.getBeanDefinitionNames();
		for (String bean : beans) {
			System.out.println(bean);
		}	
		
		return "";
	}
}
