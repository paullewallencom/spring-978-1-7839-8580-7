package com.spring_cookbook.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring_cookbook.domain.User;

@Controller
public class UserController {
	
	@RequestMapping("/user_list")
	public void userList() {
	}

	@RequestMapping("addUser")
	public String addUser() {
		return "addUser";
	}
	
	@RequestMapping(value="addUser", method=RequestMethod.POST)
	public String addUser(@ModelAttribute User user) {
		System.out.println(user.getFirstName());
		System.out.println(user.isMarried());
		return "redirect:/user_list";
	}
	
	@ModelAttribute("defaultUser")
	public User defaultUser() {
		User user = new User();
		user.setFirstName("Joe");
		user.setMarried(true);
		return user;
	}
	}
