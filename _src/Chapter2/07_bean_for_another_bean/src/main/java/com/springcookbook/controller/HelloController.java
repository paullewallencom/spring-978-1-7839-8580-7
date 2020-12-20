package com.springcookbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springcookbook.service.UserService;

@Controller
public class HelloController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("hi")
	@ResponseBody
	public String hi() {
		return "it's working: " + userService.getDataSource().toString();
	}
}
