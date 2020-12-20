package com.spring_cookbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_cookbook.domain.User;
import com.spring_cookbook.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("user_list")
	@ResponseBody
	public void userList() {
		List<User> userList = userService.findAll();
		for (User user : userList) {
			System.out.println("User " + user.getAge() + " is " + user.getAge() + " years old");
		}
	}
}
