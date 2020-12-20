package com.spring_cookbook.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/user_list")
	public String userListNormal(HttpServletRequest request) {
		System.out.println("normal");
		return "user_list";
	}

	@RequestMapping("/m/user_list")
	public String userListMobile(HttpServletRequest request) {
		System.out.println("mobile");
		return "user_list";
	}

}
