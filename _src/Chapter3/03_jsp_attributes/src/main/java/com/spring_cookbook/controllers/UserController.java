package com.spring_cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/user/list")
	public void userList(Model model) {
		model.addAttribute("nbUsers", 13);
	}

}
