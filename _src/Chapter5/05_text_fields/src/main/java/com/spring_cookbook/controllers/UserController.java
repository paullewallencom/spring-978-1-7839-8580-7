package com.spring_cookbook.controllers;

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
		System.out.println(user.getFirstName1());
		System.out.println(user.getFirstName2());
		System.out.println(user.getFirstName3());
		System.out.println(user.getFirstName4());
		return "redirect:/user_list";
	}
	
	@ModelAttribute("defaultUser")
	public User defaultUser() {
		User user = new User();
		user.setFirstName1("default1");
		user.setFirstName2("default2");
		user.setFirstName3("default3");	// this won't actually work (not possible to set a default value for a hidden field)
		user.setFirstName4("default4");
		return user;
	}
}
