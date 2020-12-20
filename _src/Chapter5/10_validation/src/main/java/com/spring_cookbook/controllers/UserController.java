package com.spring_cookbook.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public String addUser(@ModelAttribute("defaultUser") @Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return "addUser";	
		 }
		 else {
			 // validation was successful, redirect to another page
			System.out.println(user.getFirstName());
			System.out.println(user.getAge());
			return "redirect:/user_list";
		 }
	}
	
	@ModelAttribute("defaultUser")
	public User defaultUser() {
		User user = new User();

		user.setFirstName("Joe");
		user.setAge(45);		

		return user;
	}
}
