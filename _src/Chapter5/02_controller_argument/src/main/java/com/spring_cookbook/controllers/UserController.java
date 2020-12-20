package com.spring_cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String addUserSubmit(@RequestParam("firstName") String firstName) {
		System.out.println(firstName);
		return "redirect:/user_list";
	}

}
