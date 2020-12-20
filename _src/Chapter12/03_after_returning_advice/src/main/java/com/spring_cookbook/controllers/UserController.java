package com.spring_cookbook.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

@Controller
public class UserController {
	
	@RequestMapping("user_list")
	@ResponseBody
	public String userList(Locale locale, WebRequest request) {
		return "just a test";
	}
	
}
